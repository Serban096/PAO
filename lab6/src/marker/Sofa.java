package src.marker;

class Sofa {
    private String color;
    private int age;

    public Sofa(String color, int age) {
        this.color = color;
        this.age = age;
    }
    public void transform() throws NonTransformableException {
        throw new NonTransformableException("Obiectul Sofa nu poate fi transformat!");
    }

}
