class Constructor{
    String meterialType;
    int goldRate;

    public Constructor(String meterialType, int goldRate) {
      this.meterialType = meterialType;
      this.goldRate = goldRate;
    }
    public static void main(String [] args){
      Constructor construct = new Constructor("Gold", 7000);
      System.out.println("materialTypr" + ": " + construct.meterialType);
      System.out.println("Goldrate" + ": " + construct.goldRate);

    }
 
}