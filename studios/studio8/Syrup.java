package studio8;

import java.util.Random;

public class Syrup {

	public double density;
	public String brand;
	Random rand = new Random();

	public Syrup(String brand, double density) {

		this.density = density;
		this.brand = brand;
	}

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
//		long temp;
//		temp = Double.doubleToLongBits(density);
//		result = prime * result + (int) (temp ^ (temp >>> 32));
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Syrup other = (Syrup) obj;
//		if (brand == null) {
//			if (other.brand != null)
//				return false;
//		} else if (!brand.equals(other.brand))
//			return false;
//		if (Double.doubleToLongBits(density) != Double.doubleToLongBits(other.density))
//			return false;
//		return true;
//	}

	public int hashCode(){
		return brand.hashCode() + (int)density;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Syrup other = (Syrup) obj;  
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (Double.doubleToLongBits(density) != Double
				.doubleToLongBits(other.density))
			return false;
		return true;
	}



}

