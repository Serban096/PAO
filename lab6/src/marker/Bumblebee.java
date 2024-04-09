package src.marker;

class Bumblebee implements Transformable {
    private String color;
    private boolean friendly;

    public Bumblebee(String color, boolean friendly) {
        this.color = color;
        this.friendly = friendly;
    }

    public void transform() throws NonTransformableException {
        throw new NonTransformableException("Bumblebee se transforma!");
    }
}
