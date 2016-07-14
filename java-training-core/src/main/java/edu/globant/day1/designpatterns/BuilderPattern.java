package edu.globant.day1.designpatterns;

class Cpu {
	private int cores;
	private double frequency;
	public Cpu(int cores, double frequency) {
		super();
		this.cores = cores;
		this.frequency = frequency;
	}
	public int getCores() {
		return cores;
	}
	public double getFrequency() {
		return frequency;
	}
}

class Ram {
	private int capacity;
	public Ram(int capacity) {
		this.capacity = capacity;
	}
	public int getCapacity() {
		return capacity;
	}
}

class HardStorage {
	private int capacity;
	private String type;
	public HardStorage(int capacity, String type) {
		super();
		this.capacity = capacity;
		this.type = type;
	}
	public int getCapacity() {
		return capacity;
	}
	public String getType() {
		return type;
	}
}

class VideoCard {
	private int memory;
	public VideoCard(int memory) {
		super();
		this.memory = memory;
	}
	public int getMemory() {
		return memory;
	}
}

class Keyboard {
	private String language;
	public Keyboard(String language) {
		super();
		this.language = language;
	}
	public String getLanguage() {
		return language;
	}
}

class Screen {
	private String resolution;
	public Screen(String resolution) {
		super();
		this.resolution = resolution;
	}
	public String getResolution() {
		return resolution;
	}
}

class Laptop {
	private Cpu uP;
	private Ram memory;
	private HardStorage storage;
	private VideoCard videoCard;
	private Keyboard keyboard;
	private Screen screen;

	public Laptop(Cpu uP, Ram memory, HardStorage storage, VideoCard videoCard, Keyboard keyboard, Screen screen) {
		super();
		this.uP = uP;
		this.memory = memory;
		this.storage = storage;
		this.videoCard = videoCard;
		this.keyboard = keyboard;
		this.screen = screen;
	}
	public Cpu getuP() {
		return uP;
	}
	public Ram getMemory() {
		return memory;
	}
	public HardStorage getStorage() {
		return storage;
	}
	public VideoCard getVideoCard() {
		return videoCard;
	}
	public Keyboard getKeyboard() {
		return keyboard;
	}
	public Screen getScreen() {
		return screen;
	}
	@Override
	public String toString() {
		return String.format("This is a laptop with a processor of %d cores %.2f GHz,"
				+ " RAM memory of %d GBs, a %s disk with %d GBs of capacity,"
				+ " an integrated video card of %d GBs of memory,"
				+ " keyboard of language %s"
				+ " and a screen with resolution %s.",
				uP.getCores(), uP.getFrequency(),
				memory.getCapacity(), storage.getType(), storage.getCapacity(),
				videoCard.getMemory(),
				keyboard.getLanguage(),
				screen.getResolution());
	}
}

class LaptopBuilder {
	private Cpu uP;
	private Ram memory;
	private HardStorage storage;
	private VideoCard videoCard;
	private Keyboard keyboard;
	private Screen screen;
	public LaptopBuilder() {
		uP = new Cpu(2, 2.1);
		memory = new Ram(4);
		storage = new HardStorage(500, "HDD");
		videoCard = new VideoCard(1);
		keyboard = new Keyboard("english");
		screen = new Screen("720");
	}
	public LaptopBuilder setCpuCores(int cores) {
		uP = new Cpu(cores, uP.getFrequency());
		return this;
	}
	public LaptopBuilder setCpuFrequency(double frequency) {
		uP = new Cpu(uP.getCores(), frequency);
		return this;
	}
	public LaptopBuilder setRamMemory(int capacity) {
		memory = new Ram(capacity);
		return this;
	}
	public LaptopBuilder setHardStorageCapacity(int capacity) {
		storage = new HardStorage(capacity, storage.getType());
		return this;
	}
	public LaptopBuilder setHardStorageType(String type) {
		storage = new HardStorage(storage.getCapacity(), type);
		return this;
	}
	public LaptopBuilder setVideoCardMemory(int memory) {
		videoCard = new VideoCard(memory);
		return this;
	}
	public LaptopBuilder setKeyboardLanguage(String language) {
		keyboard = new Keyboard(language);
		return this;
	}
	public LaptopBuilder setScreenResolution(String resolution) {
		screen = new Screen(resolution);
		return this;
	}
	public Laptop createLaptop() {
		return new Laptop(uP, memory, storage, videoCard, keyboard, screen);
	}
}

public class BuilderPattern {

	public static void main(String[] args) {
		Laptop defaultModel = new LaptopBuilder().createLaptop();
		Laptop graphicsDesignerModel = new LaptopBuilder()
				.setCpuCores(4)
				.setCpuFrequency(2.1)
				.setRamMemory(8)
				.setHardStorageCapacity(750)
				.setVideoCardMemory(4)
				.setScreenResolution("1080p")
				.createLaptop();
		Laptop developerModel = new LaptopBuilder()
				.setCpuCores(16)
				.setCpuFrequency(4.2)
				.setRamMemory(32)
				.setHardStorageCapacity(512)
				.setHardStorageType("SSD")
				.setVideoCardMemory(2)
				.setScreenResolution("1080p")
				.createLaptop();
		System.out.println(defaultModel);
		System.out.println(graphicsDesignerModel);
		System.out.println(developerModel);
	}
}
