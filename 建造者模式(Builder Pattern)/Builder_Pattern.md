## Builder模式

###  1.简单吹吹
将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。

android中我们常见的用到它的就有Notification和AlertDialog等，拿Dialog来说，你项目中可能需要的对话框的样式多种多样，
如果你用这种形式创建

Eg:

Dialog(String title)

Dialog(String title,String message)

Dialog(String title,String message,String btnOkString)

Dialog(String title,String message,String btnOkString,String btnCancelString)

这种方法很有效，但是它的缺点很多。我们需要写多种参数组合的构造函数，而且其中还需要设置默认参数值，呵呵，这是一件苦差事，JJ做不到。其次，灵活性也不高，例如 ： Dialog("cjj", null, "ok")，显然message就没有意义，但是你要符合Java多态的特效，所以必须这样写了,后期维护你都会觉得蛋疼，所以android用了builder模式。

### 2.简单Demo
```java
package com.cjj.pattern.builder;

/**
 * @author cjj
 *         忍者
 */
public class Ninja {

    protected String name;
    protected int age;//年龄
    protected int level;//等级
    protected int sex;//性别
    protected int height;//身高
    protected String like;//爱好

    public Ninja(NinjaBuilder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.level = builder.level;
        this.height = builder.height;
        this.sex = builder.sex;
        this.like = builder.like;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getLevel() {
        return level;
    }


    public int getSex() {
        return sex;
    }


    public int getHeight() {
        return height;
    }


    public String getLike() {
        return like;
    }

    @Override
    public String toString() {
        return "Ninja{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", level=" + level +
                ", sex=" + sex +
                ", height=" + height +
                ", like='" + like + '\'' +
                '}';
    }

    public static class NinjaBuilder {

        protected String name;
        protected int age;//年龄
        protected int level;//等级
        protected int sex;//性别
        protected int height;//身高
        protected String like;//爱好

        public void NinJaBuilder() {
        }

        public NinjaBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public NinjaBuilder withLike(String like) {
            this.like = like;
            return this;
        }

        public NinjaBuilder withAge(int age) {
            this.age = age;
            return this;
        }

        public NinjaBuilder withLevel(int level) {
            this.level = level;
            return this;
        }

        public NinjaBuilder withHeight(int height) {
            this.height = height;
            return this;
        }

        public NinjaBuilder withSex(int sex) {
            this.sex = sex;
            return this;
        }

        public Ninja build(){
            return new Ninja(this);
        }

    }
}


```
以上是个忍者类，里面有各个属性，接下来写个demo来把鸣人 、佐助 、小樱给创建出来

```java
package com.cjj.pattern.builder;

/**
 * Created by cjj on 2016/2/23.
 */
public class DemoTest {

    public static void main(String agrs[]){
        Ninja naruto  = new Ninja.NinjaBuilder().withName("鸣人").withAge(13).withSex(0).withHeight(173).withLevel(1).withLike("吃拉面").build();
        System.out.printf(naruto.toString());

        Ninja zuozu = new Ninja.NinjaBuilder().withName("佐助").withAge(14).withSex(0).withHeight(174).withLevel(1).withLike("装逼").build();
        System.out.printf(zuozu.toString());

        Ninja xiaoying = new Ninja.NinjaBuilder().withName("小樱").withAge(14).withSex(1).withHeight(170).withLevel(1).withLike("花痴").build();
        System.out.printf(xiaoying.toString());
    }
}

```
以上的例子可能不符合场景，啊哈哈，个人爱好而已，你可以把他换成创建汽车需要各个组件 、组装电脑需要各个配置等零件这些比较符合的demo,呵呵，原理是一样的，学以致用就可以了。

### 3.简单UML

![]data:image/png;base64,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)

### 4.简单总结
一般来说，如果对象的建造很复杂，那么请用工厂模式；如果对象的建造更复杂，那么请用建造者模式。

（这不是教程，只是个人笔记而已，所以随意了点，看到的朋友见谅，啊哈哈哈）









