// class Node
// {
//     constructor(value)
//     {
//         this.next=undefined;
//         this.value=value;
//     }
// };

// class List
// {
//     constructor()
//     {
//         this.head=undefined;
//     }

//     /* Determine whether the list is empty. */
//     IsEmpty()
//     {
//         /* Your Code Here */
//     }

//     /* Insert a node with the given value to the end of the list */
//     PushBack(value) {
//         let new_node = Node(value)
//     {
//         if(this.head == null) {
//             this.head=value;
//         }
//         else {

//         }
//         }
//     }

//     /* Insert an array of nodes with the given values to the end of the list. */
//     PushBackN(arr)
//     {
//         /* Your Code Here */
//     }

//     Iterate(fn)
//     {
//         for(let node=this.head;node;node=node.next){fn(node.value);}
//     }
// };

// let test_data1=123;
// let test_data2=234;
// let test_data3=345;
// let test_data4=[111,222,333,444,555];

// /* Create our list */
// let list=new List();
// /* Insert nodes into the list: */
// list.PushBack(test_data1);
// list.PushBack(test_data2);
// list.PushBack(test_data3);
// /* Insert array of nodes into the list: */
// list.PushBackN(test_data4);
// /* Iterate our list, so we can see our node values */
// list.Iterate(value=>console.log(value));


class Node
{
    constructor(value)
    {
        this.next=undefined;
        this.value=value;
    }
};

class List
{
    constructor()
    {
        this.head=undefined;
    }

    /* Determine whether the list is empty. */
    IsEmpty()
    {
        if(this.head == null){
            return ("this list is empty")
        }
    }

    /* Insert a node with the given value to the end of the list */
    PushBack(value)
    {
        if(this.head == null){
            this.head = new Node(value)
            return this
        }
        var newNode = new Node(value)
        var findNext = this.head;
        while (findNext.next != null) {
            findNext = findNext.next
        }
        findNext.next = newNode

    return this
    }

    /* Insert an array of nodes with the given values to the end of the list. */
    PushBackN(arr)
    {
        for (var i = 0;i < arr.length; i++){
            this.PushBack(arr[i])
        }

    return this
    }

    Iterate(fn)
    {
        for(let node=this.head;node;node=node.next){fn(node.value);}
    }
};