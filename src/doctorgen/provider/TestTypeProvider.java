package doctorgen.provider;

public class TestTypeProvider extends AbstractProvider {
//	stuff = {{"Проверка комплектности и маркировки", false}
//	}
	Object[][] stuff = { { "Проверка комплектности и маркировки", false },
			{ "Проверка электрического сопротивления изоляции", false } };
	
	public Object[][] getStuff(){
		return stuff;
	}
}
