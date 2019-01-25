package rating;

public class TestRating {

	public static void main(String[] args) {
		// Listing all the ratings and their ordinal
		System.out.println("List of all Standards & Poors ratings and their ordinal");
		System.out.println(Rates.AAA + "\t" + Rates.AAA.ordinal());
		System.out.println(Rates.AAP + "\t" + Rates.AAP.ordinal());
		System.out.println(Rates.AA + "\t" + Rates.AA.ordinal());
		System.out.println(Rates.AAM + "\t" + Rates.AAM.ordinal());
		System.out.println(Rates.AP + "\t" + Rates.AP.ordinal());
		System.out.println(Rates.A + "\t" + Rates.A.ordinal());
		System.out.println(Rates.AM + "\t" + Rates.AM.ordinal());
		System.out.println(Rates.BBBP + "\t" + Rates.BBBP.ordinal());
		System.out.println(Rates.BBB + "\t" + Rates.BBB.ordinal());
		System.out.println(Rates.BBBM + "\t" + Rates.BBBM.ordinal());
		System.out.println(Rates.BBP + "\t" + Rates.BBP.ordinal());
		System.out.println(Rates.BB + "\t" + Rates.BB.ordinal());
		System.out.println(Rates.BBM + "\t" + Rates.BBM.ordinal());
		System.out.println(Rates.BP + "\t" + Rates.BP.ordinal());
		System.out.println(Rates.B + "\t" + Rates.B.ordinal());
		System.out.println(Rates.BM + "\t" + Rates.BM.ordinal());
		System.out.println(Rates.CCCP + "\t" + Rates.CCCP.ordinal());
		System.out.println(Rates.CCC + "\t" + Rates.CCC.ordinal());
		System.out.println(Rates.CCCM + "\t" + Rates.CCCM.ordinal());
		System.out.println(Rates.CC + "\t" + Rates.CC.ordinal());
		System.out.println(Rates.C + "\t" + Rates.C.ordinal());
		System.out.println(Rates.SD + "\t" + Rates.SD.ordinal());
		System.out.println(Rates.D + "\t" + Rates.D.ordinal());

		System.out.println();
		System.out.println("Use of changeRatingByNotches()");
		for (int i = -10; i < 10; i++) {
			if (i < 0) {
				System.out.println("BB " + i + " notches ==> " + Rates.changeRatingByNotches("BB", i));
			} else {
				System.out.println("BB +" + i + " notches ==> " + Rates.changeRatingByNotches("BB", i));
			}
		}

		System.out.println();
		System.out.println("Use of downgradeRating() or upgradeRating()");
		System.out.println("Downgrade of BBB+ ==> " + Rates.downgradeRating("BBBP"));
		System.out.println("Downgrade of CCC+ ==> " + Rates.downgradeRating("CCCP"));
		System.out.println("Upgrade   of AA+  ==> " + Rates.upgradeRating("AAP"));
		System.out.println("Downgrade of AA+  ==> " + Rates.downgradeRating("AAP"));
		System.out.println("Downgrade of c    ==> " + Rates.upgradeRating("c"));
		System.out.println("Upgrade   of A+   ==> " + Rates.upgradeRating("AP"));
		System.out.println("Downgrade of D    ==> " + Rates.downgradeRating("D"));
	}
}
