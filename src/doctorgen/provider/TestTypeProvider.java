package doctorgen.provider;

public class TestTypeProvider extends AbstractProvider {
//	stuff = {{"�������� ������������� � ����������", false}
//	}
	Object[][] stuff = { { "�������� ������������� � ����������", false },
			{ "�������� �������������� ������������� ��������", false } };
	
	public Object[][] getStuff(){
		return stuff;
	}
}
