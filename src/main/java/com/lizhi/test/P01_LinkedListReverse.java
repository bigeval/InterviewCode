package com.lizhi.test;

/**
 * 插头法
 */
public class P01_LinkedListReverse {
    public static void main(String[] args) {

    }
    //ListNode 是定义的单链表结构
//head 是传进来单链表的头部
//假如是 1->2->3->4
    public  ListNode  reverse(ListNode head){
        //base-case处理，如果链表是空、或者只有一个元素，直接返回
        if(head==null ||head.next==null) return head;

        //定义新的链表和临时变量
        ListNode newList=null;//新链表的头指针是空的

        ListNode tmp=head;

        //循环处理
        while(tmp!=null){
            ListNode nextList=tmp.next;  //先把剩下的链表保存

            tmp.next=newList; // 把tmp依次倒置  1  2->1  3->2->1  4->3->2->1
            newList=tmp; // 把tmp赋值给newList

            tmp=nextList; //tmp回到原链表，再往下走
        }
        return newList;

    }

}

 class ListNode {
    int value; // 数值域  //-------------------->数值的类型
    ListNode next; //节点域
    //定义一个构造函数
    public ListNode(int value){
        this.value = value;
    }

    // java的强数据类型
    // 基本数据类型  引用数据类型   -----》java为什么喜欢定义数据类型
    // js: var a  = '123';    var b = 10;  var f = 1.0;
    //java: String a = "123";  int b = 1; float f = 1.0;
    // ------>定义数据类型-----》明确如何开辟内存空间---------->定义什么样的数据类型就以为值在内存当中开辟什么样的内存空间
    // int a = 10;  ----> 1bit 31bit
    // float a = 10.0; -----> 1bit 8bit 23bit

    // -------------------------------------》
    // next区域存储的是下一个节点(对象)的地址  ------- 什么才能存储对象的地址？
    // ListNode node1 = new ListNode(1);  node1变量之所以能存储对象的地址是因为ListNode这个类型定义在我们当前这个对象在内存当中开辟什么样的内存空间。
    //                                    所以我们当前next变量的类型只能是ListNode。


    @Override
    public String toString() {
        return "ListNode{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}
