class Node<T> {

    Node(T value){
        this.value = value;
    }
    final T value;
    Node<T> parent;
    Node<T> left;
    Node<T> right;
}
