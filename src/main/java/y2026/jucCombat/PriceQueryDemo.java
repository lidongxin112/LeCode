package y2026.jucCombat;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * 题目.5
 * CompletableFuture 并发询价
 */
public class PriceQueryDemo {
    public static void main(String[] args) {
        ExecutorService executor = new ThreadPoolExecutor(
                3,
                6,
                60,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(100)
        );

        try {
            CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(() -> queryPrice("渠道A", 1200), executor);
            CompletableFuture<Integer> f2 = CompletableFuture.supplyAsync(() -> queryPrice("渠道B", 1100), executor);
            CompletableFuture<Integer> f3 = CompletableFuture.supplyAsync(() -> queryPrice("渠道C", 1300), executor);

            List<Integer> prices = CompletableFuture.allOf(f1, f2, f3)
                    .thenApply(v -> Arrays.asList(f1.join(), f2.join(), f3.join()))
                    .join();

            Integer minPrice = prices.stream().min(Integer::compareTo).orElseThrow();
            System.out.println("所有报价: " + prices);
            System.out.println("最低价: " + minPrice);
        } finally {
            executor.shutdown();
        }
    }

    private static Integer queryPrice(String channel, int price) {
        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(channel + " 返回价格: " + price);
        return price;
    }
}
