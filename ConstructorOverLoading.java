class ConstructorOverLoading {
    String materialType;
    int rate;
    static ConstructorOverLoading overLoading;
    ConstructorOverLoading () {

    }

    ConstructorOverLoading (String type) {
        this.materialType = type;
    }

    ConstructorOverLoading (int rate) {
        this.rate = rate;
    }

    ConstructorOverLoading (String type, int rate) {
        this.materialType = type;
        this.rate = rate;
    }

    public static void main(String [] args) {
       overLoading = new ConstructorOverLoading();
       System.out.println("No Args " + overLoading);
       overLoading = new ConstructorOverLoading("Dimond");
       System.out.println("One Args " + overLoading.materialType);
       overLoading = new ConstructorOverLoading(20);
       System.out.println("One Args " + overLoading.rate);
       overLoading = new ConstructorOverLoading("Dimond", 20);
       System.out.println("Two Args " + overLoading.materialType + " " + overLoading.rate);
    }
}