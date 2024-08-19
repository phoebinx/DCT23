package practice.arrays;

public class ContainerWithMostWater {
	public static void main(String args[]) {
		ContainerWithMostWater obj = new ContainerWithMostWater();
		int height[] = {1,8,6,2,5,4,8,3,7};
		System.out.println(obj.maxArea(height));
	}
	public int maxArea(int[] height) {
		int l = 0; int r = height.length-1;
		int area = 0;
		while (l<r) {
			area = Math.max(area, Math.min(height[l], height[r]) * (r-l));
			if (height[l] < height[r])
				l++;
			else
				r--;
		}
		return area;
	}
}
