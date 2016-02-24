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

这种方法很有效，但是它的缺点很多。我们需要写多种参数组合的构造函数，而且其中还需要设置默认参数值，呵呵，这是一件苦差事，JJ做不到。其次，灵活性也不高，such as，Dialog("cjj", null, "ok")，显然message就没有意义，但是你要符合Java多态的特效，所以必须这样写了,后期维护你都会觉得蛋疼

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









