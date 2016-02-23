## 1.简单吹吹

###  Builder模式
将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。

android中我们常见的用到它的就有Notification和AlertDialog等，拿Dialog来说，你项目中可能需要的对话框的样式多种多样，
如果你用这种形式创建

Eg:

Dialog(String title)

Dialog(String title,String message)

Dialog(String title,String message,String btnOkString)

Dialog(String title,String message,String btnOkString,String btnCancelString)

这种方法很有效，但是它的缺点很多。我们需要写多种参数组合的构造函数，而且其中还需要设置默认参数值，呵呵，这是一件苦差事，JJ做不到。其次，灵活性也不高，such as，Dialog("cjj", null, "ok")，显然message就没有意义，但是你要符合Java多态的特效，所以必须这样写了。







