package EnumTest;

public enum Grade {
	
	A("100-90"){
		@Override
		public String localValue(){
			return "优";
		}
	},
	B("89-90") {
		@Override
		public String localValue() {
			return "良";
		}
	},
	C("79-70") {
		@Override
		public String localValue() {
			return "一般";
		}
	},
	D("69-60") {
		@Override
		public String localValue() {
			return "及格";
		}
	},
	E("59-0") {
		@Override
		public String localValue() {
			return "不及格";
		}
	};
	
	private String value;
	
	private Grade(String value){
		this.value = value;
	}
	public String getValue(){
		return this.value;
	}
	public abstract String localValue();
	
}
