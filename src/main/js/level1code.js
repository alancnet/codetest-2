var code = {
  // Returns "Hello World!"
  helloWorld: function () {
    return "Hello World!";
  },
  // Defines a singly-linked list implementation:
  linkedList: {
    head: null,
    tail: null,
    add: function (data) {
      var makeNode = function (value) { return { data: value, next: null }; };
      var newNode = makeNode(data);

      if (!this.head) this.head = newNode;

      if (this.tail) this.tail.next = newNode;

      this.tail = newNode;
      //throw new Error("Not Implemented");
    },
    run: function (func) {

      var current = this.head;
      var data = null;
      while (current.next) {
        data = func(current.data, data);
        current = current.next;
      }
      return data;
    },
    // returns the smallest number in the list
    min: function () {
      return this.run(function (current, data) {
        if (data === null || current < data)
          return current;
        else
          return data;
      });
      //throw new Error("Not Implemented");
    },
    // returns the largest number in the list
    max: function () {
      return this.run(function (current, data) {
        if (data === null || current > data)
          return current;
        else
          return data;
      });
      //throw new Error("Not Implemented")
    },
    // returns the length of the list
    length: function () {
      return this.run(function (_, data) {
        if (data === null)
          return 1;
        else
          return data + 1;
      });
      //throw new Error("Not Implemented");
    }
  },  
  // return a linked list object that contains 
  // every integer starting at 'start' and ending at 'end'
  countFromTo: function (start, end) {

    var list = Object.create(this.linkedList);
    for (var i = start; i <= end; i++) {
      list.add(i);
    };
    return list;
    //throw new Error("Not Implemented");
  }
};
module.exports = code;