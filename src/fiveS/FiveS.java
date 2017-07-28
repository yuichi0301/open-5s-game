package fiveS;

/*
 * Copyright (C) 2007 by Yuichi Uchida
 * 2007/01/14
 */

import com.nttdocomo.ui.*;

public class FiveS extends IApplication {
	FSDisplay fiveS;

	public void start() {
		fiveS = new FSDisplay();
		PhoneSystem.setAttribute(PhoneSystem.DEV_KEYPAD, 1); //�N���A�{�^���⃍�[���L�[�Ȃǂ��g�����߂̑O����,����L�[�̏���
		Display.setCurrent(fiveS);
		fiveS.init();
		fiveS.paint(fiveS.getGraphics());
	}
}
