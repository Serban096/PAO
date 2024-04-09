package src.marker;

class TestNotTransformable {
    public static void main(String[] args) {
        Sofa sofa = new Sofa("brown", 5);
        try {
            sofa.transform();
        } catch (NonTransformableException e) {
            System.out.println(e.getMessage());
        }
    }
}
