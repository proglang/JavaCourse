package lesson_03;

import lesson_02.FareZone;

public class Validation {

	private long timestamp; // Zeitstempel der Entwertung (in Millisekunden seit 1.1.1970)

	private FareZone zone; // new: Ort der Entwertung: ZONE_A, ZONE_B, ZONE_C

	public Validation(long timestamp, FareZone zone) {
		this.timestamp = timestamp;
		this.zone = zone;
	}

	public long timeSinceCreated(long t) {
		return t - timestamp;
	}

	public int levelDiff(FareZone z) {
		return Math.abs(zone.ordinal() - z.ordinal());
	}

	// later in lesson_04
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (timestamp ^ (timestamp >>> 32));
		result = prime * result + ((zone == null) ? 0 : zone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Validation other = (Validation) obj;
		if (timestamp != other.timestamp)
			return false;
		if (zone != other.zone)
			return false;
		return true;
	}
	
	

}
