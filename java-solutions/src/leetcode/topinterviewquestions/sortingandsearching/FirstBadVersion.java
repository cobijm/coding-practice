package sortingandsearching;

public class FirstBadVersion {

	public static boolean isBadVersion(int version) {
		if (version >= 4) {
			return true;
		}
		return false;
	}

	public static int firstBadVersion(int n) {
		int low = 0;
		int high = n;
		int mid;

		while (low <= high) {
			mid = low + (high - low) / 2;
			if (isBadVersion(mid) == false) {
				low = mid + 1;
			} else if (isBadVersion(mid) == true && isBadVersion(mid - 1) == false) {
				return mid;
			} else if (isBadVersion(mid) == true) {
				high = mid - 1;
			}
		}
		return n;
	}

	public static void main(String[] args) {
		System.out.println(firstBadVersion(5));
	}

}
