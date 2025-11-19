package simple;

public class DoubleLink<T>{
    private class Node<T>{
        //节点值
        private T value;
        //前一个节点
        private Node<T> prev;
        //后一个节点
        private Node<T> prex;

        public Node(T value, Node<T> prev, Node<T> prex) {
            this.value = value;
            this.prev = prev;
            this.prex = prex;
        }
    }
    //链表长度
    private int size;
    //头节点
    private Node<T> head;

    public DoubleLink() {
        head = new Node<>(null,null,null);
        head.prev  = head.prex;
        head = head.prex;
        size = 0;
    }

    public int getSize() {
        return this.size;
    }
    //是否为空
    public boolean isEmplty(){
        return size == 0;
    }
    //判断索引是否超出范围
    public void checkIndex(int index){
        if (index<0||index>=size){
            throw new IndexOutOfBoundsException();
        }
        return;
    }
    /*
    通过索引获取当前节点
     */
    public Node<T> getNode(int index){
        //检索是否超出范围
        checkIndex(index);
        //从前查找
        if (index<size/2){
            Node<T> cur = head.prex;
            for (int i=0;i<index;i++){
                cur = cur.prex;
            }
            return cur;
        }
        //从后查找
        Node<T> cur = head.prev;
        int newIndex = size - (index+1);
        for (int i=0;i<newIndex;i++){
            cur = cur.prev;
        }
        return cur;
    }
    //获取节点值
    public T getValue(Node<T> cur){
        return cur.value;
    }
    //获取第一个节点值
    public T getFirst(){
        return getValue(getNode(0));
    }
    //获取最够一个节点值
    public T getLast(){
        return getValue(getNode(size-1));
    }
    //插入节点
    public void insert(int index,T value){
        if (index==0){
            Node<T> cur = new Node<T>(value,head,head.prex);
            head.prex.prev = cur;
            head.prex = cur;
            size++;
        }
        /*
        根据插入位置，找到该链表的节点
         */
        Node<T> node = getNode(index);
        Node<T> cur = new Node<T>(value,node,node.prex);
        node.prex.prev = cur;
        node.prex = cur;
        size++;
    }
    //向表头插入数据
    public void insertTo(T value){
        insert(0,value);
    }
    //将元素插入到链表的尾部
    public void insertTotatil(T value){

    }
    //删除节点
    public void del(int index){
        checkIndex(index);
        Node<T> cur = getNode(index);
        cur.prev.prex = cur.prex;
        cur.prex.prev = cur.prev;
        size--;
        cur = null;
        return;
    }
    //删除第一个
    public void delFirst(){
        del(0);
    }
    public void delLast(){
        del(size-1);
    }
}
