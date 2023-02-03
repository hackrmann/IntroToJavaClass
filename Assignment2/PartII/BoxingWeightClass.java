
public class BoxingWeightClass {

	public static String findWeightClass(float weight) {
		// this is really only valid for weights greater than 0.
		return null;
	}
	
	public static void main(String[] args) {
		
		/* you probably want to use user input for the
		 * income using Scanner because you will have to convert
		 * a command line argument to an float, and we haven't
		 * gotten to string parsing yet
		 * 
		 * But you can also just set the "weight" variable
		 * to whatever you want in the code, and that's fine too
		 */
		
		float weight = 1;
		String weightClass = findWeightClass(weight);
		
		// if the digits are greater than zero print this out:
		System.out.println("The weight class for the weight " + weight + " is " 
		+ weightClass);
		
	}
}
