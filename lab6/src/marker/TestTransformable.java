package src.marker;

class TestTransformable {
    public static void main(String[] args) {
        Bumblebee bumblebee = new Bumblebee("yellow", true);
        try {
            bumblebee.transform();
        } catch (NonTransformableException e) {
            System.out.println(e.getMessage());
        }
    }
}
