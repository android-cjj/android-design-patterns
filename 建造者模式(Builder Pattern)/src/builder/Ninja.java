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
