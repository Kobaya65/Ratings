package rating;

public enum Rates {
	AAA("AAA"), AAP("AA+"), AA("AA"), AAM("AA-"), AP("A+"), A("A"), AM("A-"), BBBP("BBB+"), BBB("BBB"), BBBM("BBB-"),
	BBP("BB+"), BB("BB"), BBM("BB-"), BP("B+"), B("B"), BM("B-"), CCCP("CCC+"), CCC("CCC"), CCCM("CCC-"), CC("CC"),
	C("C"), SD("SD"), D("D");

	String Rate;

	private Rates(String ratingName) {
		Rate = ratingName;
	}

	/**
	 * This function changes the rating by the number of notches asked, up or down.
	 * Negative number of notches to downgrade (ex. from AAA to AA+), positive
	 * number of notches to upgrade (ex. from B- to BBB+).
	 * 
	 * @param rating  the rating to change
	 * @param notches number of notches to add to current rating
	 * 
	 * @return the updated rating
	 */
	public static String changeRatingByNotches(String rating, int notches) {
		String[] rl = ratingsList();

		// retrieve ordinal of the rating in order to compute the new one
		// based on the number of notches in argument
		int ordinal = Rates.valueOf(rating).ordinal();

		// compute the new rating, taking care of bounds
		// (0 and number of ratings - 1)
		int newOrdinal = 0;
		if (Math.signum((float) notches) == -1.0) {
			newOrdinal = Math.min(Rates.values().length - 1, ordinal - notches);
		} else if (Math.signum((float) notches) == 1.0) {
			newOrdinal = Math.max(0, ordinal - notches);
		} else {
			// if notches = 0
			newOrdinal = ordinal;
		}

		// newRating
		return rl[newOrdinal];
	}

	/**
	 * This function aims at upgrading the rating by one notch (ex. AA+ to AAA)
	 * 
	 * @param the rating to upgrade
	 * @return the upgraded rating
	 */
	public static String upgradeRating(String rating) {
		String[] rl = ratingsList();

		try {
			// retrieve ordinal of the rating in order to compute the new one
			int ordinal = Rates.valueOf(rating).ordinal();

			// compute the new rating, taking care of bounds
			// want to upgrade, so need to get the previous index
			int newOrdinal = Math.max(0, ordinal - 1);

			return rl[newOrdinal];
		} catch (IllegalArgumentException e) {
			// newRating
			return (e.toString());
		}
	}

	/**
	 * This function aims at downgrading the rating by one notch (ex. AA+ to AA)
	 * 
	 * @param the rating to downgrade
	 * @return the downgraded rating
	 */
	public static String downgradeRating(String rating) {
		String[] rl = ratingsList();

		// retrieve ordinal of the rating in order to compute the new one
		int ordinal = Rates.valueOf(rating).ordinal();

		// compute the new rating, taking care of bounds
		// want to downgrade, so need to get the next index
		int newOrdinal = Math.min(Rates.values().length - 1, ordinal + 1);

		// newRating
		return rl[newOrdinal];
	}

	/**
	 * This function creates a list of ratings in order for the upgrade and
	 * downgrade functions (changeRatingByNotches, downgradeRating and
	 * upgradeRating) to be able to return the new calculated rating
	 * 
	 * @return a String array figuring the ratings with their related index
	 */
	private static String[] ratingsList() {
		String[] arr = new String[Rates.values().length];

		// index for the array
		int i = 0;

		// loop on Rates and store its values in the array arr[]
		// with same index than in enumeration
		for (Rates str : Rates.values()) {
			arr[i] = str.toString();
			i++;
		}

		return arr;
	}
}
