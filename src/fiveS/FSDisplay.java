package fiveS;

/*
 * Copyright (C) 2007 by Yuichi Uchida
 * 2007/01/14
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;

import javax.microedition.io.Connector;

import com.nttdocomo.ui.*;
class FSDisplay extends Canvas {
	int state; //��ԑJ�ڃt���O
	//���j���[���
	final int INIT = 0; //�N����
	final int MENU = 1; //MENU
	final int SINDAN = 2; //5�r�f�f
	final int KAKUNIN = 3; //5�r�̊m�F
	final int KEKKA = 4; //�f�f�̌��ʂ�\�����L�^����
	final int INFO = 5; //5S�̐���
	final int KEKKA2 = 6; //�f�f�̌��ʂ�\�����L�^����
	final int INFO2 = 7; //5S�̐���
	final int INFO3 = 8; //5S�̐���

	//�m�F��ʂ̃y�[�W(11�`39)
	final int SETUGU_AISATU = 11; //�ڋ��i�������j
	final int SETUGU_KOTOBA = 12; //�ڋ��i���t�����j
	final int SETUGU_DENWA = 13; //�ڋ��i�d�b�Ή��j
	final int FOURS = 14; //�����E���ځE�|���E������4�r
	final int KODO_JOUHOU = 15; //�s���E��񊴓x
	final int AISATU2 = 16; //�ڋ�����p��̃y�[�W
	final int KOTOBA2 = 17; //�ڋ��i���t�����j2�y�[�W��
	final int DENWA2 = 18; //�d�b����2�y�[�W��
	final int FOURS2 = 19; //4S2�y�[�W��
	final int KODO_JOUHOU2 = 20; //�s���E��񊴓x2�y�[�W��
	final int MIDASINAMI = 21; //�g�����Ȃ݁E�p��
	final int MIDASINAMI2 = 22; //�g�����Ȃ݁E�p��2�y�[�W��
	//�f�f��ʂ̃y�[�W(41�`100)
	final int SINDAN_FOURS = 41; //�f�f��ʂ�4�r
	final int SINDAN_FOURS2 = 42; //�f�f��ʂ�4�r2�y�[�W��
	final int SINDAN_FOURS3 = 43; //�f�f��ʂ�4�r3�y�[�W��
	final int SINDAN_FOURS4 = 44; //�f�f��ʂ�4�r4�y�[�W��
	final int SINDAN_FOURS5 = 45; //�f�f��ʂ�4�r5�y�[�W��
	final int SINDAN_FOURS6 = 46; //�f�f��ʂ�4�r6�y�[�W��
	final int SINDAN_FOURS_KEKKA = 47; //�f�f��ʂ�4�r�̌���
	//�f�f��ʂ݂����Ȃ݂̃y�[�W
	final int SINDAN_MIDASINAMI = 48; //�f�f��ʂ̐g�����Ȃ�
	final int SINDAN_MIDASINAMI2 = 49; //�f�f��ʂ̐g�����Ȃ�
	final int SINDAN_MIDASINAMI3 = 50; //�f�f��ʂ̐g�����Ȃ�
	final int SINDAN_MIDASINAMI4 = 51; //�f�f��ʂ̐g�����Ȃ�
	final int SINDAN_MIDASINAMI5 = 52; //�f�f��ʂ̐g�����Ȃ�
	final int SINDAN_MIDASINAMI6 = 53; //�f�f��ʂ̐g�����Ȃ�
	final int SINDAN_MIDASINAMI7 = 54; //�f�f��ʂ̐g�����Ȃ�
	final int SINDAN_MIDASINAMI_KEKKA = 55;

	//�f�f��ʂ̂������̃y�[�W
	final int SINDAN_SETUGU_AISATU = 56; //�f�f��ʂ̂�������
	final int SINDAN_SETUGU_AISATU2 = 57;
	final int SINDAN_SETUGU_AISATU3 = 58;
	final int SINDAN_SETUGU_AISATU4 = 59;
	final int SINDAN_SETUGU_AISATU_KEKKA = 60;

	//	�f�f��ʂ̌��t�̃y�[�W
	final int SINDAN_SETUGU_KOTOBA = 61; //�f�f��ʂ̌��t����
	final int SINDAN_SETUGU_KOTOBA2 = 62;
	final int SINDAN_SETUGU_KOTOBA3 = 63;
	final int SINDAN_SETUGU_KOTOBA4 = 64;
	final int SINDAN_SETUGU_KOTOBA5 = 65;
	final int SINDAN_SETUGU_KOTOBA6 = 66;
	final int SINDAN_SETUGU_KOTOBA7 = 67;
	final int SINDAN_SETUGU_KOTOBA8 = 68;
	final int SINDAN_SETUGU_KOTOBA_KEKKA = 69;

	//�f�f��ʂ̓d�b�̃y�[�W
	final int SINDAN_SETUGU_DENWA = 70; //�f�f��ʂ̓d�b����	
	final int SINDAN_SETUGU_DENWA2 = 71;
	final int SINDAN_SETUGU_DENWA3 = 72;
	final int SINDAN_SETUGU_DENWA4 = 73;
	final int SINDAN_SETUGU_DENWA5 = 74;
	final int SINDAN_SETUGU_DENWA6 = 75;
	final int SINDAN_SETUGU_DENWA7 = 76;
	final int SINDAN_SETUGU_DENWA_KEKKA = 77;

	//�f�f��ʂ̍s����񊴓x�̃y�[�W
	final int SINDAN_KODO_JOUHOU = 78; //�f�f��ʂ̍s����񊴓x
	final int SINDAN_KODO_JOUHOU2 = 79;
	final int SINDAN_KODO_JOUHOU3 = 80;
	final int SINDAN_KODO_JOUHOU4 = 81;
	final int SINDAN_KODO_JOUHOU5 = 82;
	final int SINDAN_KODO_JOUHOU6 = 83;
	final int SINDAN_KODO_JOUHOU7 = 84;
	final int SINDAN_KODO_JOUHOU_KEKKA = 85;

	//�I�v�V�����̃y�[�W
	final int OPTION = 99; //�I�v�V�������
	//MENU
	final int MENU_SINDAN = 0; //�f�f
	final int MENU_KAKUNIN = 1; //�m�F
	final int MENU_KEKKA = 2; //����
	final int MENU_INFO = 3; //����
	final int MENU_OPTION = 4; //�I�v�V����
	final int MENU_NUM = 6;
	final int MENU_NUM2 = 5;
	final int MENU_KAKUNIN_NUM = 6;
	final int OPTION_MENUY = 9;
	final int OPTION_MENUX = 3;
	final int MENU_SELECT = 3;
	//KAKUNIN_MENU
	final int KAKUNIN_MENU_4S = 0; //�����E���ځE�|���E������4�r
	final int KAKUNIN_MENU_MIDASINAMI = 1; //�g�����Ȃ݁E�p��	
	final int KAKUNIN_MENU_SETUGU_AISATU = 2; //�ڋ��i�������j
	final int KAKUNIN_MENU_SETUGU_KOTOBA = 3; //�ڋ��i���t�����j
	final int KAKUNIN_MENU_SETUGU_DENWA = 4; //�ڋ��i�d�b�Ή��j
	final int KAKUNIN_MENU_KODO_JOUHOU = 5; //�s���E��񊴓x
	//	SINDAN_MENU
	final int SINDAN_MENU_4S = 0; //�����E���ځE�|���E������4�r
	final int SINDAN_MENU_MIDASINAMI = 1; //�g�����Ȃ݁E�p��	
	final int SINDAN_MENU_SETUGU_AISATU = 2; //�ڋ��i�������j
	final int SINDAN_MENU_SETUGU_KOTOBA = 3; //�ڋ��i���t�����j
	final int SINDAN_MENU_SETUGU_DENWA = 4; //�ڋ��i�d�b�Ή��j
	final int SINDAN_MENU_KODO_JOUHOU = 5; //�s���E��񊴓x

	//�{�^���ʒu
	final int BUTTON_X = 210;
	final int BUTTON_Y_1 = 30;
	final int BUTTON_Y_2 = 70;
	final int BUTTON_Y_3 = 110;
	//�{�^���̃`�F�b�N�������Ă��邩�ۂ�
	private boolean check1 = false;
	private boolean check2 = false;
	private boolean check3 = false;
	private boolean check4 = false;
	private boolean check5 = false;
	private boolean check6 = false;
	private boolean check7 = false;
	private boolean check8 = false;
	private boolean check9 = false;
	//���_�̎�ނ̃t���O
	private int shuruiFlg = 0;
	//�����̔���Ɏg���p�����[�^�B
	private int seikai1 = 1;
	private int seikai2 = 2;
	private int seikai3 = 3;
	//�Œ�1�`�F�b�N�������Ă��邩�̃t���O
	private boolean checkFlg = false;
	private boolean checkFlg1 = false;
	private boolean checkFlg2 = false;
	private boolean checkFlg3 = false;
	int focusedMenu; //MENU�̃t�H�[�J�X�ʒu
	int focusedSelect; //SelectMENU�̃t�H�[�J�X�ʒu
	int focusedMenuKakunin; //�f�f�E�m�FMENU�̃t�H�[�J�X�ʒu	
	//�L�����p�����[�^
	private int m = 0;
	//�w���t�H�[�J�X�x���t�H�[�J�X�ʒu�����킹���ϐ�
	private int focuse = 0;
	//X��Y���t�H�[�J�X�ʒu
	private int sfocusedSelectx;
	private int sfocusedSelecty;
	//�{�^��
	private int BUTTONX1 = 20;
	private int BUTTONX2 = 80;
	private int BUTTONX3 = 150;
	private int BUTTONY1 = 60;
	private int BUTTONY2 = 130;
	private int BUTTONY3 = 200;
	//���_
	private int tokuten = 0;
	//�������_
	private int sougoutokuten = 0;
	//��{�F�̕ϐ�
	private int colorR;
	private int colorG;
	private int colorB;
	//�w�i�F�̕ϐ�
	private int bcolorR;
	private int bcolorG;
	private int bcolorB;
	/** �\�����郁�b�Z�[�W�̕����� */
	private String KakuninStr1;
	private String KakuninStr2;
	private String KakuninStr3;
	private String KakuninStr4;
	private String KakuninStr5;
	private String KakuninStr6;
	private String KakuninStr7;
	private String KakuninStr8;
	private String KakuninStr9;
	private String KakuninStr10;
	private String KakuninStr11;
	//���_�̐�
	final int TOKUTEN_NUM = 6;
	//���_���i�[����ϐ�
	private int tokutens[] = new int[6];
	//�I�񂾍���
	private int choice = 0;
	Font f;
	final int margin = 10;
	final int arrowSize = 5;
	//�X�N���b�`�p�b�h��ǂݍ��񂾂Ƃ��̃L�����N�^�[�t���O0:�T1:�j�̎q2:���̎q
	private int characterFlg = 0;
	//�ō����_�̍폜�t���O
	private int deleteFlg = 0;
	//	�^�C�g���A���S�AMENU�摜
	MediaImage titleMI;
	Image titleImage;
	MediaImage logoMI;
	Image logoImage;
	MediaImage[] mMI;
	Image[] mImage;
	//	�L�����摜
	MediaImage[] kame1MI;
	MediaImage[] otoko1MI;
	MediaImage[] onna1MI;
	Image[] characterImage;
	FSDisplay() {
		state = INIT;
		mMI = new MediaImage[MENU_NUM - 1]; //Super5S�̐����ɂ��Ă̓��S���g������MENU_NUM-1
		mImage = new Image[MENU_NUM - 1];
		f = Font.getDefaultFont(); // �t�H���g�̐ݒ�		
	}
	int focusedTokuten; //���_�̃t�H�[�J�X�ʒu
	int[] focusedIndex = new int[10]; //���_������	
	public void init() {
		loadHiscore();
		loadOption();
		//�^�C�g�����S�摜�Ǎ���
		if (titleMI == null) {
			titleMI = MediaManager.getImage("resource:///5StTitle.gif");
			try {
				titleMI.use();
			} catch (Exception e) {
			}
			titleImage = titleMI.getImage();
		}
		//�^�C�g�����S�摜�Ǎ���
		if (logoMI == null) {
			logoMI = MediaManager.getImage("resource:///5SLogo.gif");
			try {
				logoMI.use();
			} catch (Exception e) {
			}
			logoImage = logoMI.getImage();
		}
		//MENU�摜�̓Ǎ���
		for (int i = 0; i < MENU_NUM - 1; i++) {
			mMI[i] = MediaManager.getImage("resource:///m" + i + ".gif");
			try {
				mMI[i].use();
			} catch (Exception e) {
			}
			mImage[i] = mMI[i].getImage();
		}
		//�z��̏���
		kame1MI = new MediaImage[6];
		otoko1MI = new MediaImage[6];
		onna1MI = new MediaImage[6];
		characterImage = new Image[6];
		//�f�t�H���g�ł̓L�����N�^�[�Ƃ��ċT���g���B
		switch (characterFlg) {
			case 0 :
				for (int i = 0; i < 6; i++) {
					kame1MI[i] =
						MediaManager.getImage("resource:///kame" + i + ".gif");
					try {
						kame1MI[i].use();
					} catch (Exception e) {
					}
					characterImage[i] = kame1MI[i].getImage();
				}
				break;
			case 1 :
				for (int i = 0; i < 6; i++) {
					otoko1MI[i] =
						MediaManager.getImage("resource:///otoko" + i + ".gif");
					try {
						otoko1MI[i].use();
					} catch (Exception e) {
					}
					characterImage[i] = otoko1MI[i].getImage();
				}
				break;
			case 2 :
				for (int i = 0; i < 6; i++) {
					onna1MI[i] =
						MediaManager.getImage("resource:///onna" + i + ".gif");
					try {
						onna1MI[i].use();
					} catch (Exception e) {
					}
					characterImage[i] = onna1MI[i].getImage();
				}
				break;
		}
		sfocusedSelectx = 0;
		sfocusedSelecty = 3;

		state = MENU;
	}
	/**
	 * �n�C�X�R�A�����[�h����	
	 */
	private void loadHiscore() {
		int pos = 0;
		//�X�N���b�`�p�b�h����̃f�[�^�̓Ǎ���
		try {
			for (int i = 0; i < 6; i++) {
				DataInputStream in =
					Connector.openDataInputStream("scratchpad:///0;pos=" + pos);
				if (in.readByte() == 1) {
					//�X�N���b�`�p�b�h�ɕۑ�����Ă���n�C�X�R�A�����[�h����
					tokutens[i] = in.readInt();
				} else {
					tokutens[i] = 0;
				}
				in.close();
				pos += 8;
			}
		} catch (Exception e) {

		}
	}
	/**
	 * �n�C�X�R�A���X�N���b�`�p�b�h�ɕۑ�����
	 */
	private void saveHiScore() {
		switch (shuruiFlg) {
			case 1 :
				try {
					DataOutputStream out =
						Connector.openDataOutputStream("scratchpad:///0");
					out.writeByte(1);
					out.writeInt(tokutens[0]);
					out.close();
				} catch (Exception e) {
				}
				break;
			case 2 :
				try {
					DataOutputStream out =
						Connector.openDataOutputStream("scratchpad:///0;pos=8");
					out.writeByte(1);
					out.writeInt(tokutens[1]);
					out.close();
				} catch (Exception e) {
				}
				break;
			case 3 :
				try {
					DataOutputStream out =
						Connector.openDataOutputStream(
							"scratchpad:///0;pos=16");
					out.writeByte(1);
					out.writeInt(tokutens[2]);
					out.close();
				} catch (Exception e) {
				}
				break;
			case 4 :
				try {
					DataOutputStream out =
						Connector.openDataOutputStream(
							"scratchpad:///0;pos=24");
					out.writeByte(1);
					out.writeInt(tokutens[3]);
					out.close();
				} catch (Exception e) {
				}
				break;
			case 5 :
				try {
					DataOutputStream out =
						Connector.openDataOutputStream(
							"scratchpad:///0;pos=32");
					out.writeByte(1);
					out.writeInt(tokutens[4]);
					out.close();
				} catch (Exception e) {
				}
				break;
			case 6 :
				try {
					DataOutputStream out =
						Connector.openDataOutputStream(
							"scratchpad:///0;pos=40");
					out.writeByte(1);
					out.writeInt(tokutens[5]);
					out.close();
				} catch (Exception e) {
				}
				break;

		}
	}
	/**
	 * �n�C�X�R�A���폜����
	 */
	private void deleteSave() {
		int pos = 0;
		try {
			for (int i = 0; i < 6; i++) {
				DataOutputStream out =
					Connector.openDataOutputStream(
						"scratchpad:///0;pos=" + pos);
				out.writeByte(1);
				out.writeInt(0);
				out.close();
				pos += 8;
			}
		} catch (Exception e) {
		}
	}
	/**
	 * �I�v�V�����f�[�^�������[�h����	
	 */
	private void loadOption() {
		//�X�N���b�`�p�b�h����̃f�[�^�̓Ǎ���
		try {
			DataInputStream in =
				Connector.openDataInputStream("scratchpad:///0;pos=48");
			if (in.readByte() == 1) {
				colorR = in.readInt();
			} else {
				colorR = 252;
			}
			in.close();

		} catch (Exception e) {

		}
		try {
			DataInputStream in =
				Connector.openDataInputStream("scratchpad:///0;pos=56");
			if (in.readByte() == 1) {
				colorG = in.readInt();
			} else {
				colorG = 127;
			}
			in.close();

		} catch (Exception e) {

		}
		try {
			DataInputStream in =
				Connector.openDataInputStream("scratchpad:///0;pos=64");
			if (in.readByte() == 1) {
				colorB = in.readInt();
			} else {
				colorB = 127;
			}
			in.close();

		} catch (Exception e) {

		}
		try {
			DataInputStream in =
				Connector.openDataInputStream("scratchpad:///0;pos=72");
			if (in.readByte() == 1) {
				bcolorR = in.readInt();
			} else {
				bcolorR = 255;
			}
			in.close();

		} catch (Exception e) {

		}
		try {
			DataInputStream in =
				Connector.openDataInputStream("scratchpad:///0;pos=80");
			if (in.readByte() == 1) {
				bcolorG = in.readInt();
			} else {
				bcolorG = 230;
			}
			in.close();

		} catch (Exception e) {

		}
		try {
			DataInputStream in =
				Connector.openDataInputStream("scratchpad:///0;pos=88");
			if (in.readByte() == 1) {
				bcolorB = in.readInt();
			} else {
				bcolorB = 255;
			}
			in.close();

		} catch (Exception e) {

		}
		//�L�����N�^�[�Ɋւ��Ă̓t���O�ŏ���
		try {
			DataInputStream in =
				Connector.openDataInputStream("scratchpad:///0;pos=96");
			if (in.readByte() == 1) {
				characterFlg = in.readInt();
			} else {
				characterFlg = 0;
			}
			in.close();

		} catch (Exception e) {

		}
	}
	/**
	 * �I�v�V�����f�[�^���X�N���b�`�p�b�h�ɕۑ�����
	 */
	private void saveOption() {
		try {
			DataOutputStream out =
				Connector.openDataOutputStream("scratchpad:///0;pos=48");
			out.writeByte(1);
			out.writeInt(colorR);
			out.close();
		} catch (Exception e) {
		}

		try {
			DataOutputStream out =
				Connector.openDataOutputStream("scratchpad:///0;pos=56");
			out.writeByte(1);
			out.writeInt(colorG);
			out.close();
		} catch (Exception e) {
		}

		try {
			DataOutputStream out =
				Connector.openDataOutputStream("scratchpad:///0;pos=64");
			out.writeByte(1);
			out.writeInt(colorB);
			out.close();
		} catch (Exception e) {
		}

		try {
			DataOutputStream out =
				Connector.openDataOutputStream("scratchpad:///0;pos=72");
			out.writeByte(1);
			out.writeInt(bcolorR);
			out.close();
		} catch (Exception e) {
		}

		try {
			DataOutputStream out =
				Connector.openDataOutputStream("scratchpad:///0;pos=80");
			out.writeByte(1);
			out.writeInt(bcolorG);
			out.close();
		} catch (Exception e) {
		}

		try {
			DataOutputStream out =
				Connector.openDataOutputStream("scratchpad:///0;pos=88");
			out.writeByte(1);
			out.writeInt(bcolorB);
			out.close();
		} catch (Exception e) {
		}
		try {
			DataOutputStream out =
				Connector.openDataOutputStream("scratchpad:///0;pos=96");
			out.writeByte(1);
			out.writeInt(characterFlg);
			out.close();
		} catch (Exception e) {
		}
	}
	/** ���Ӄ_�C�A���O�{�b�N�X��\������ **/
	private void chuui(int joutai) {
		if (checkFlg) {
			Dialog d = new Dialog(Dialog.DIALOG_ERROR, "����");
			d.setText("�Œ�1�̓`�F�b�N���ĂˁI");
			d.show();
		} else {
			//�t���O������������B
			check1 = false;
			check2 = false;
			check3 = false;
			checkFlg = false;
			focusedSelect = 0;
			state = joutai;
		}
	}
	private void chuuioption(int joutai) {
		if (checkFlg1) {
			if (checkFlg2) {
				if (checkFlg3) {
					Dialog d = new Dialog(Dialog.DIALOG_ERROR, "����");
					d.setText("�`�F�b�N��\n�S�������Ă��܂��B");
					d.show();
				} else {
					Dialog d = new Dialog(Dialog.DIALOG_ERROR, "����");
					d.setText("�L�����I���ƐF�I����\n�`�F�b�N�������Ă܂��B");
					d.show();
				}
			} else {
				if (checkFlg3) {
					Dialog d = new Dialog(Dialog.DIALOG_ERROR, "����");
					d.setText("�L�����I���Ɣw�i�F�I����\n�`�F�b�N�������Ă܂��B");
					d.show();
				} else {
					Dialog d = new Dialog(Dialog.DIALOG_ERROR, "����");
					d.setText("�L�����I���̃`�F�b�N��\n�����Ă܂��B");
					d.show();
				}
			}
		} else {
			if (checkFlg2) {
				if (checkFlg3) {
					Dialog d = new Dialog(Dialog.DIALOG_ERROR, "����");
					d.setText("�F�Ɣw�i�F�I����\n�`�F�b�N�������Ă܂��B");
					d.show();
				} else {
					Dialog d = new Dialog(Dialog.DIALOG_ERROR, "����");
					d.setText("�F�̃`�F�b�N��\n�����Ă܂��B");
					d.show();
				}
			} else {
				if (checkFlg3) {
					Dialog d = new Dialog(Dialog.DIALOG_ERROR, "����");
					d.setText("�w�i�F�I����\n�`�F�b�N�������Ă܂��B");
					d.show();
				} else {
					//�t���O������������B
					check1 = false;
					check2 = false;
					check3 = false;
					check4 = false;
					check5 = false;
					check6 = false;
					check7 = false;
					check8 = false;
					check9 = false;

					checkFlg1 = false;
					checkFlg2 = false;
					checkFlg3 = false;
					sfocusedSelectx = 0;
					sfocusedSelecty = 0;
					state = joutai;
				}
			}
		}
	}
	private void option(Graphics g) {
		focuse = sfocusedSelectx + sfocusedSelecty;
		g.setColor(Graphics.getColorOfRGB(188, 143, 143));
		g.fillRect(0, 0, Display.getWidth(), Display.getHeight());
		g.setColor(Graphics.getColorOfRGB(254, 254, 254));
		g.fillRect(5, 24, Display.getWidth() - 10, 50);
		g.fillRect(5, 96, Display.getWidth() - 10, 50);
		g.fillRect(5, 168, Display.getWidth() - 10, 50);
		g.setColor(Graphics.getColorOfRGB(0, 0, 0));
		g.drawRect(0, 0, Display.getWidth(), Display.getHeight() - 1);
		g.drawRect(5, 24, Display.getWidth() - 10, 50);
		g.drawRect(5, 96, Display.getWidth() - 10, 50);
		g.drawRect(5, 168, Display.getWidth() - 10, 50);
		//�{�^���̘g��`��1���
		g.setColor(Graphics.getColorOfRGB(0, 0, 0));
		g.drawArc(BUTTONX1 + 42, BUTTONY1 - 10, 10, 10, 0, 360);
		g.drawArc(BUTTONX1 + 42 - 2, BUTTONY1 - 12, 14, 14, 0, 360);
		g.setColor(Graphics.getColorOfRGB(252, 127, 127));

		g.setColor(Graphics.getColorOfRGB(0, 0, 0));
		g.drawArc(BUTTONX1 + 42, BUTTONY2 - 10, 10, 10, 0, 360);
		g.drawArc(BUTTONX1 + 42 - 2, BUTTONY2 - 12, 14, 14, 0, 360);
		g.setColor(Graphics.getColorOfRGB(252, 127, 127));

		g.setColor(Graphics.getColorOfRGB(0, 0, 0));
		g.drawArc(BUTTONX1 + 42, BUTTONY3 - 10, 10, 10, 0, 360);
		g.drawArc(BUTTONX1 + 42 - 2, BUTTONY3 - 12, 14, 14, 0, 360);
		//�{�^���̘g��`��Q���
		g.setColor(Graphics.getColorOfRGB(0, 0, 0));
		g.drawArc(BUTTONX2 + 55, BUTTONY1 - 10, 10, 10, 0, 360);
		g.drawArc(BUTTONX2 + 55 - 2, BUTTONY1 - 12, 14, 14, 0, 360);
		g.setColor(Graphics.getColorOfRGB(252, 127, 127));

		g.setColor(Graphics.getColorOfRGB(0, 0, 0));
		g.drawArc(BUTTONX2 + 55, BUTTONY2 - 10, 10, 10, 0, 360);
		g.drawArc(BUTTONX2 + 55 - 2, BUTTONY2 - 12, 14, 14, 0, 360);
		g.setColor(Graphics.getColorOfRGB(252, 127, 127));

		g.setColor(Graphics.getColorOfRGB(0, 0, 0));
		g.drawArc(BUTTONX2 + 55, BUTTONY3 - 10, 10, 10, 0, 360);
		g.drawArc(BUTTONX2 + 55 - 2, BUTTONY3 - 12, 14, 14, 0, 360);
		//�{�^���̘g��`��R���
		g.setColor(Graphics.getColorOfRGB(0, 0, 0));
		g.drawArc(BUTTONX3 + 65, BUTTONY1 - 10, 10, 10, 0, 360);
		g.drawArc(BUTTONX3 + 65 - 2, BUTTONY1 - 12, 14, 14, 0, 360);
		g.setColor(Graphics.getColorOfRGB(252, 127, 127));

		g.setColor(Graphics.getColorOfRGB(0, 0, 0));
		g.drawArc(BUTTONX3 + 65, BUTTONY2 - 10, 10, 10, 0, 360);
		g.drawArc(BUTTONX3 + 65 - 2, BUTTONY2 - 12, 14, 14, 0, 360);
		g.setColor(Graphics.getColorOfRGB(252, 127, 127));

		g.setColor(Graphics.getColorOfRGB(0, 0, 0));
		g.drawArc(BUTTONX3 + 65, BUTTONY3 - 10, 10, 10, 0, 360);
		g.drawArc(BUTTONX3 + 65 - 2, BUTTONY3 - 12, 14, 14, 0, 360);
		g.drawString("�L�����I��", 10, 18);
		g.drawString("��{�F�I��", 10, 90);
		g.drawString("�w�i�F�I��", 10, 164);
		String[] menu =
			{
				"",
				"",
				"",
				"1.�T",
				"2.�j�̎q",
				"3.���̎q",
				"1.��",
				"2.��",
				"3.��",
				"1.����",
				"2.����",
				"3.����" };
		int x = 10;
		int y = 30;
		int[] yi = new int[10];
		yi[3] = BUTTONY1;
		yi[6] = BUTTONY2;
		yi[9] = BUTTONY3;
		int[] xi = { BUTTONX1, BUTTONX2, BUTTONX3 };
		//�`�F�b�N�̏���1���
		if (check1) {
			g.setColor(Graphics.getColorOfRGB(188, 143, 143));
			g.fillArc(BUTTONX1 + 44, BUTTONY1 - 8, 7, 7, 0, 360);
		} else {
			g.setColor(Graphics.getColorOfRGB(252, 252, 252));
			g.fillArc(BUTTONX1 + 44, BUTTONY1 - 8, 7, 7, 0, 360);
		}
		if (check4) {
			g.setColor(Graphics.getColorOfRGB(188, 143, 143));
			g.fillArc(BUTTONX1 + 44, BUTTONY2 - 8, 7, 7, 0, 360);
		} else {
			g.setColor(Graphics.getColorOfRGB(252, 252, 252));
			g.fillArc(BUTTONX1 + 44, BUTTONY2 - 8, 7, 7, 0, 360);
		}
		if (check7) {
			g.setColor(Graphics.getColorOfRGB(188, 143, 143));
			g.fillArc(BUTTONX1 + 44, BUTTONY3 - 8, 7, 7, 0, 360);
		} else {
			g.setColor(Graphics.getColorOfRGB(254, 254, 254));
			g.fillArc(BUTTONX1 + 44, BUTTONY3 - 8, 7, 7, 0, 360);
		}
		//�`�F�b�N�̏���2���
		if (check2) {
			g.setColor(Graphics.getColorOfRGB(188, 143, 143));
			g.fillArc(BUTTONX2 + 57, BUTTONY1 - 8, 7, 7, 0, 360);
		} else {
			g.setColor(Graphics.getColorOfRGB(252, 252, 252));
			g.fillArc(BUTTONX2 + 57, BUTTONY1 - 8, 7, 7, 0, 360);
		}
		if (check5) {
			g.setColor(Graphics.getColorOfRGB(188, 143, 143));
			g.fillArc(BUTTONX2 + 57, BUTTONY2 - 8, 7, 7, 0, 360);
		} else {
			g.setColor(Graphics.getColorOfRGB(252, 252, 252));
			g.fillArc(BUTTONX2 + 57, BUTTONY2 - 8, 7, 7, 0, 360);
		}
		if (check8) {
			g.setColor(Graphics.getColorOfRGB(188, 143, 143));
			g.fillArc(BUTTONX2 + 57, BUTTONY3 - 8, 7, 7, 0, 360);
		} else {
			g.setColor(Graphics.getColorOfRGB(254, 254, 254));
			g.fillArc(BUTTONX2 + 57, BUTTONY3 - 8, 7, 7, 0, 360);
		}
		//�`�F�b�N�̏���3���
		if (check3) {
			g.setColor(Graphics.getColorOfRGB(188, 143, 143));
			g.fillArc(BUTTONX3 + 67, BUTTONY1 - 8, 7, 7, 0, 360);
		} else {
			g.setColor(Graphics.getColorOfRGB(252, 252, 252));
			g.fillArc(BUTTONX3 + 67, BUTTONY1 - 8, 7, 7, 0, 360);
		}
		if (check6) {
			g.setColor(Graphics.getColorOfRGB(188, 143, 143));
			g.fillArc(BUTTONX3 + 67, BUTTONY2 - 8, 7, 7, 0, 360);
		} else {
			g.setColor(Graphics.getColorOfRGB(252, 252, 252));
			g.fillArc(BUTTONX3 + 67, BUTTONY2 - 8, 7, 7, 0, 360);
		}
		if (check9) {
			g.setColor(Graphics.getColorOfRGB(188, 143, 143));
			g.fillArc(BUTTONX3 + 67, BUTTONY3 - 8, 7, 7, 0, 360);
		} else {
			g.setColor(Graphics.getColorOfRGB(254, 254, 254));
			g.fillArc(BUTTONX3 + 67, BUTTONY3 - 8, 7, 7, 0, 360);
		}
		//�t�H�[�J�X
		g.setColor(Graphics.getColorOfRGB(188, 143, 143));
		g.fillRect(
			xi[sfocusedSelectx] - margin / 2 + 4,
			yi[sfocusedSelecty] - f.getHeight() - margin / 2,
			f.stringWidth(menu[sfocusedSelectx + sfocusedSelecty]) + margin - 4,
			f.getHeight() + margin);
		g.drawString(menu[3], BUTTONX1, BUTTONY1);
		g.drawString(menu[4], BUTTONX2, BUTTONY1);
		g.drawString(menu[5], BUTTONX3, BUTTONY1);
		g.drawString(menu[6], BUTTONX1, BUTTONY2);
		g.drawString(menu[7], BUTTONX2, BUTTONY2);
		g.drawString(menu[8], BUTTONX3, BUTTONY2);
		g.drawString(menu[9], BUTTONX1, BUTTONY3);
		g.drawString(menu[10], BUTTONX2, BUTTONY3);
		g.drawString(menu[11], BUTTONX3, BUTTONY3);
		//�t�H�[�J�X�̂������Ă��鍀�ڂ͔������ɂ���
		g.setColor(Graphics.getColorOfName(Graphics.WHITE));
		g.drawString(
			menu[sfocusedSelectx + sfocusedSelecty],
			xi[sfocusedSelectx],
			yi[sfocusedSelecty]);

		//�Ƃ肠�����A�S�Ẳ摜�f�[�^��s�g�p�ɂ��Ĕj������B
		for (int i = 0; i < 3; i++) {
			if (kame1MI[i] != null) {
				kame1MI[i].unuse();
				kame1MI[i].dispose();
				kame1MI[i] = null;
			}
		}
		for (int i = 0; i < 4; i++) {
			if (otoko1MI[i] != null) {
				otoko1MI[i].unuse();
				otoko1MI[i].dispose();
				otoko1MI[i] = null;
			}
		}
		for (int i = 0; i < 4; i++) {
			if (onna1MI[i] != null) {
				onna1MI[i].unuse();
				onna1MI[i].dispose();
				onna1MI[i] = null;
			}
		}
		//�`�F�b�N�P�Ȃ�L�����N�^�[�ɋT���A2�Ȃ�j�A3�Ȃ珗
		if (check1) {
			for (int i = 0; i < 6; i++) {
				kame1MI[i] =
					MediaManager.getImage("resource:///kame" + i + ".gif");
				try {
					kame1MI[i].use();
				} catch (Exception e) {
				}
				characterImage[i] = kame1MI[i].getImage();
			}
			characterFlg = 0;
		}
		if (check2) {
			for (int i = 0; i < 6; i++) {
				otoko1MI[i] =
					MediaManager.getImage("resource:///otoko" + i + ".gif");
				try {
					otoko1MI[i].use();
				} catch (Exception e) {
				}
				characterImage[i] = otoko1MI[i].getImage();
			}
			characterFlg = 1;
		}
		if (check3) {
			for (int i = 0; i < 6; i++) {
				onna1MI[i] =
					MediaManager.getImage("resource:///onna" + i + ".gif");
				try {
					onna1MI[i].use();
				} catch (Exception e) {
				}
				characterImage[i] = onna1MI[i].getImage();
			}
			characterFlg = 2;
		}
		//��{�F������B
		//�Ԃ̂Ƃ�
		if (check4) {
			colorR = 252;
			colorG = 127;
			colorB = 127;
		}
		//�΂̂Ƃ�
		if (check5) {
			colorR = 46;
			colorG = 139;
			colorB = 87;
		}
		//�̂Ƃ�
		if (check6) {
			colorR = 30;
			colorG = 144;
			colorB = 255;
		}
		//�w�i�F������B
		//�Ԃ̂Ƃ�
		if (check7) {
			bcolorR = 255;
			bcolorG = 240;
			bcolorB = 255;
		}
		//�΂̂Ƃ�
		if (check8) {
			bcolorR = 194;
			bcolorG = 255;
			bcolorB = 197;
		}
		//���F�̂Ƃ�
		if (check9) {
			bcolorR = 255;
			bcolorG = 255;
			bcolorB = 239;
		}
		//1���`�F�b�N����ĂȂ��Ƃ��̓_�C�A���O�{�b�N�X��\���B
		if ((!check1) && (!check2) && (!check3)) {
			checkFlg1 = true;
		} else {
			checkFlg1 = false;
		}
		if ((!check4) && (!check5) && (!check6)) {
			checkFlg2 = true;
		} else {
			checkFlg2 = false;
		}
		if ((!check7) && (!check8) && (!check9)) {
			checkFlg3 = true;
		} else {
			checkFlg3 = false;
		}
		g.setColor(Graphics.getColorOfRGB(188, 143, 143));
		g.drawString("���S��1�̓`�F�b�N���Ă��������B", 10, 230);
		saveOption();
	}
	//�L�^��ʂ̏���**********************************************************************************************

	public void kiroku(Graphics g) {
		g.setColor(Graphics.getColorOfRGB(bcolorR, bcolorG, bcolorB));
		g.fillRect(0, 0, Display.getWidth(), Display.getHeight());
		g.setColor(Graphics.getColorOfRGB(colorR, colorG, colorB));
		g.fillRect(0, 0, Display.getWidth(), Display.getHeight());
		g.setColor(Graphics.getColorOfRGB(bcolorR, bcolorG, bcolorB));
		g.fillRect(5, 5, Display.getWidth() - 10, Display.getHeight() - 10);
		g.setColor(Graphics.getColorOfRGB(0, 0, 0));
		g.drawRect(0, 0, Display.getWidth(), Display.getHeight());
		g.drawRect(5, 5, Display.getWidth() - 10, Display.getHeight() - 10);
		g.setColor(Graphics.getColorOfRGB(0, 0, 0));
		g.drawString("����", 100, 30);
		g.drawString("�����E���ځE�|���E���|", 10, 60);
		g.drawString("�ڋ��E�g�����Ȃ݁E�p���E�\��", 10, 90);
		g.drawString("�ڋ��i�������j", 10, 120);
		g.drawString("�ڋ��i���t�����j", 10, 150);
		g.drawString("�ڋ��i�d�b���΁j", 10, 180);
		g.drawString("�s���E��񊴓x", 10, 210);
		g.drawString(tokutens[0] + "�_", 203, 60);
		g.drawString(tokutens[1] + "�_", 203, 90);
		g.drawString(tokutens[2] + "�_", 203, 120);
		g.drawString(tokutens[3] + "�_", 203, 150);
		g.drawString(tokutens[4] + "�_", 203, 180);
		g.drawString(tokutens[5] + "�_", 203, 210);
		g.setColor(Graphics.getColorOfRGB(colorR, colorG, colorB));
		g.fillRect(18, 214, 162, 15);
		g.setColor(Graphics.getColorOfName(Graphics.WHITE));
		g.drawString("������{�^���őS���_���폜", 20, 226);

	}
	public void kiroku2(Graphics g) {
		g.setColor(Graphics.getColorOfRGB(bcolorR, bcolorG, bcolorB));
		g.fillRect(0, 0, Display.getWidth(), Display.getHeight());
		g.setColor(Graphics.getColorOfRGB(colorR, colorG, colorB));
		g.fillRect(0, 0, Display.getWidth(), Display.getHeight());
		g.setColor(Graphics.getColorOfRGB(bcolorR, bcolorG, bcolorB));
		g.fillRect(5, 5, Display.getWidth() - 10, Display.getHeight() - 10);
		g.setColor(Graphics.getColorOfRGB(0, 0, 0));
		g.drawRect(0, 0, Display.getWidth(), Display.getHeight());
		g.drawRect(5, 5, Display.getWidth() - 10, Display.getHeight() - 10);
		g.setColor(Graphics.getColorOfRGB(0, 0, 0));
		g.drawString("����", 100, 30);
		g.drawString("�����E���ځE�|���E���|", 10, 60);
		g.drawString("�ڋ��E�g�����Ȃ݁E�p���E�\��", 10, 90);
		g.drawString("�ڋ��i�������j", 10, 120);
		g.drawString("�ڋ��i���t�����j", 10, 150);
		g.drawString("�ڋ��i�d�b���΁j", 10, 180);
		g.drawString("�s���E��񊴓x", 10, 210);
		g.drawString("0�_", 203, 60);
		g.drawString("0�_", 203, 90);
		g.drawString("0�_", 203, 120);
		g.drawString("0�_", 203, 150);
		g.drawString("0�_", 203, 180);
		g.drawString("0�_", 203, 210);
	}
	//�L�^��ʂ̏����I��******************************************************************************************
	//�m�F��ʂ̏���**********************************************************************************************
	private void kakunin(Graphics g) {
		String title = "�m�FMENU";
		String[] menu2 =
			{
				"�����E���ځE�|���E���|",
				"�ڋ��E�g�����Ȃ݁E�p���E�\��",
				"�ڋ��i�������j",
				"�ڋ��i���t�����j",
				"�ڋ��i�d�b���΁j",
				"�s���E��񊴓x" };
		g.setColor(Graphics.getColorOfRGB(bcolorR, bcolorG, bcolorB));
		g.fillRect(0, 0, Display.getWidth(), Display.getHeight());
		//�^�C�g���\��		
		int x = (getWidth() - f.stringWidth(title)) / 2;
		int y = 30;
		g.setColor(Graphics.getColorOfRGB(colorR, colorG, colorB));
		g.drawString(title, x, y);
		g.drawLine(x - 2, y + 2, x + f.stringWidth(title) + 2, y + 2);

		x = 60;
		int[] yi = { 50, 80, 110, 140, 170, 200 };

		//�t�H�[�J�X
		g.setColor(Graphics.getColorOfRGB(colorR, colorG, colorB));
		g.fillRect(
			x - margin / 2,
			yi[focusedMenuKakunin] - f.getHeight() - margin / 2,
			f.stringWidth(menu2[focusedMenuKakunin]) + margin,
			f.getHeight() + margin);

		//���j���[���ڕ\��
		for (int i = 0; i < menu2.length; i++) {
			g.drawString(menu2[i], x, yi[i]);
		}
		//�t�H�[�J�X�̂������Ă��鍀�ڂ͔������ɂ���
		g.setColor(Graphics.getColorOfName(Graphics.WHITE));
		g.drawString(menu2[focusedMenuKakunin], x, yi[focusedMenuKakunin]);
	}
	public void kakuninM(
		String KakuninStr1,
		String KakuninStr2,
		String KakuninStr3,
		String KakuninStr4,
		String KakuninStr5,
		String KakuninStr6,
		String KakuninStr7,
		String KakuninStr8,
		String KakuninStr9,
		String KakuninStr10,
		String KakuninStr11,
		Graphics g) {
		g.setColor(Graphics.getColorOfRGB(bcolorR, bcolorG, bcolorB));
		g.fillRect(0, 0, Display.getWidth(), Display.getHeight());
		g.setColor(Graphics.getColorOfRGB(colorR, colorG, colorB));
		g.fillRect(0, 0, Display.getWidth(), Display.getHeight());
		g.setColor(Graphics.getColorOfRGB(bcolorR, bcolorG, bcolorB));
		g.fillRect(5, 5, Display.getWidth() - 10, Display.getHeight() - 10);
		g.setColor(Graphics.getColorOfRGB(0, 0, 0));
		g.drawRect(0, 0, Display.getWidth(), Display.getHeight());
		g.drawRect(5, 5, Display.getWidth() - 10, Display.getHeight() - 10);
		g.drawString(KakuninStr1, 16, 16);
		g.drawString(KakuninStr2, 12, 30);
		g.drawString(KakuninStr3, 12, 50);
		g.drawString(KakuninStr4, 12, 70);
		g.drawString(KakuninStr5, 12, 90);
		g.drawString(KakuninStr6, 12, 110);
		g.drawString(KakuninStr7, 12, 130);
		g.drawString(KakuninStr8, 12, 150);
		g.drawString(KakuninStr9, 12, 170);
		g.drawString(KakuninStr10, 12, 190);
		g.drawString(KakuninStr11, 12, 210);
	}
	private void info(Graphics g) {
		g.setColor(Graphics.getColorOfRGB(bcolorR, bcolorG, bcolorB));
		g.fillRect(0, 0, Display.getWidth(), Display.getHeight());
		g.setColor(Graphics.getColorOfRGB(colorR, colorG, colorB));
		if (titleImage != null) {
			g.drawImage(
				titleImage,
				(getWidth() - titleImage.getWidth()) / 2,
				(getWidth() - titleImage.getWidth()) / 2);
			g.drawString(
				"Super5S Version 0.1",
				(getWidth() - f.stringWidth("Super5S Version 0.1")) / 2,
				(getWidth() - titleImage.getWidth()) / 2
					+ titleImage.getHeight()
					+ f.getHeight() * 2);
		}
		g.drawString("�����A���ځA���|�A", 12, 110);
		g.drawString("�����A�^�̂T�̓������u�r�v���Ƃ���", 12, 130);
		g.drawString("�T�r�ƌĂ΂�Ă��܂��B���������̂��A", 12, 150);
		g.drawString("�������������A�������Ƃ���ɂ�", 12, 170);
		g.drawString("�R���ɂ��q����ƂĂ��悢���̂Ȃ�ł��B", 12, 190);
		g.drawString("", 12, 210);
	}
	private void info2(Graphics g) {
		g.setColor(Graphics.getColorOfRGB(bcolorR, bcolorG, bcolorB));
		g.fillRect(0, 0, Display.getWidth(), Display.getHeight());
		g.setColor(Graphics.getColorOfRGB(colorR, colorG, colorB));
		g.drawString("1.5S�x�f�f", 12, 20);
		g.drawString("5S���ǂꂾ���o��", 40, 40);
		g.drawString("�Ă邩��f�f���܂��B", 40, 60);
		g.drawString("2.5S���m�F", 12, 90);
		g.drawString("���s�ɂ����Ă�Ƃ���", 40, 110);
		g.drawString("�o���ɂ����Ă�Ƃ���", 40, 130);
		g.drawString("���ł�5S���m�F�ł��܂��B", 40, 150);
		g.drawString("3.�f�f���ʂ̋L�^������", 12, 180);
		g.drawString("�ō����_��\�����܂��B", 40, 200);
		g.drawString("����{�^���őS���_���폜�ł��܂��B", 40, 220);
	}
	private void info3(Graphics g) {
		g.setColor(Graphics.getColorOfRGB(bcolorR, bcolorG, bcolorB));
		g.fillRect(0, 0, Display.getWidth(), Display.getHeight());
		g.setColor(Graphics.getColorOfRGB(colorR, colorG, colorB));
		g.drawString("4.5S�̐���", 12, 20);
		g.drawString("5S���̂��̂Ɗe�@�\��", 40, 40);
		g.drawString("���������܂��B�����̂��Ƃł��B", 40, 60);
		g.drawString("5.OPTION", 12, 90);
		g.drawString("�L�����I���ł́A�T�A", 40, 110);
		g.drawString("�j�̎q�A���̎q���I���ł��܂��B", 40, 130);
		g.drawString("��{�F�͐ԁA�΁A��I���ł��܂��B", 40, 150);
		g.drawString("�w�i�F�͔��ԁA���΁A������", 40, 170);
		g.drawString("�I���ł��܂��B", 40, 190);
		g.drawString("�S�ă`�F�b�N���Ȃ���", 40, 210);
		g.drawString("���֐i�܂��܂���B", 40, 230);
	}
	//�m�F��ʂ̏����I��******************************************************************************************

	//�f�f��ʂ̏���**********************************************************************************************
	private void sindan(Graphics g) {
		tokuten = 0;
		sougoutokuten = 0;
		String title = "�f�fMENU";
		String[] menu2 =
			{
				"�����E���ځE�|���E���|",
				"�ڋ��E�g�����Ȃ݁E�p���E�\��",
				"�ڋ��i�������j",
				"�ڋ��i���t�����j",
				"�ڋ��i�d�b���΁j",
				"�s���E��񊴓x" };
		g.setColor(Graphics.getColorOfRGB(bcolorR, bcolorG, bcolorB));
		g.fillRect(0, 0, Display.getWidth(), Display.getHeight());
		//�^�C�g���\��
		int x = (getWidth() - f.stringWidth(title)) / 2;
		int y = 30;
		g.setColor(Graphics.getColorOfRGB(colorR, colorG, colorB));
		g.drawString(title, x, y);
		g.drawLine(x - 2, y + 2, x + f.stringWidth(title) + 2, y + 2);

		x = 60;
		int[] yi = { 50, 80, 110, 140, 170, 200 };

		//�t�H�[�J�X
		g.setColor(Graphics.getColorOfRGB(colorR, colorG, colorB));
		g.fillRect(
			x - margin / 2,
			yi[focusedMenuKakunin] - f.getHeight() - margin / 2,
			f.stringWidth(menu2[focusedMenuKakunin]) + margin,
			f.getHeight() + margin);

		//���j���[���ڕ\��
		for (int i = 0; i < menu2.length; i++) {
			g.drawString(menu2[i], x, yi[i]);
		}
		//�t�H�[�J�X�̂������Ă��鍀�ڂ͔������ɂ���
		g.setColor(Graphics.getColorOfName(Graphics.WHITE));
		g.drawString(menu2[focusedMenuKakunin], x, yi[focusedMenuKakunin]);

	}
	public void sindanM(
		String sindantext1,
		String sindantext2,
		String sindantext3,
		String sentakutext1,
		String sentakutext2,
		String sentakutext3,
		int tokuten,
		Graphics g) {
		g.setColor(Graphics.getColorOfRGB(bcolorR, bcolorG, bcolorB));
		g.fillRect(0, 0, Display.getWidth(), Display.getHeight());
		g.setColor(Graphics.getColorOfRGB(colorR, colorG, colorB));
		g.fillRect(0, 170, Display.getWidth(), Display.getHeight() - 170);
		g.setColor(Graphics.getColorOfRGB(252, 252, 252));
		g.fillRect(50, 175, 185, 60);
		g.setColor(Graphics.getColorOfRGB(0, 0, 0));
		g.drawRect(50, 175, 185, 60);
		g.drawRect(0, 170, 239, 68);
		g.drawRect(4, 184, 41, 41);
		g.drawImage(characterImage[0], 5, 185);
		g.drawString(sindantext1, 60, 188);
		g.drawString(sindantext2, 60, 208);
		g.drawString(sindantext3, 60, 228);
		String[] menu = { sentakutext1, sentakutext2, sentakutext3 };
		int x = 10;
		int y = 30;
		g.setColor(Graphics.getColorOfRGB(colorR, colorG, colorB));
		int[] yi = { BUTTON_Y_1, BUTTON_Y_2, BUTTON_Y_3 };
		g.setColor(Graphics.getColorOfRGB(0, 0, 0));
		g.drawArc(BUTTON_X, BUTTON_Y_1 - 10, 10, 10, 0, 360);
		g.drawArc(BUTTON_X - 2, BUTTON_Y_1 - 12, 14, 14, 0, 360);

		g.drawArc(BUTTON_X, BUTTON_Y_2 - 10, 10, 10, 0, 360);
		g.drawArc(BUTTON_X - 2, BUTTON_Y_2 - 12, 14, 14, 0, 360);

		g.drawArc(BUTTON_X, BUTTON_Y_3 - 10, 10, 10, 0, 360);
		g.drawArc(BUTTON_X - 2, BUTTON_Y_3 - 12, 14, 14, 0, 360);

		if (check1) {
			g.setColor(Graphics.getColorOfRGB(colorR, colorG, colorB));
			g.fillArc(BUTTON_X + 2, BUTTON_Y_1 - 8, 7, 7, 0, 360);
			choice = 1;
		} else {
			g.setColor(Graphics.getColorOfRGB(252, 252, 252));
			g.fillArc(BUTTON_X + 2, BUTTON_Y_1 - 8, 7, 7, 0, 360);
		}
		if (check2) {
			g.setColor(Graphics.getColorOfRGB(colorR, colorG, colorB));
			g.fillArc(BUTTON_X + 2, BUTTON_Y_2 - 8, 7, 7, 0, 360);
			choice = 2;
		} else {
			g.setColor(Graphics.getColorOfRGB(252, 252, 252));
			g.fillArc(BUTTON_X + 2, BUTTON_Y_2 - 8, 7, 7, 0, 360);
		}
		if (check3) {
			g.setColor(Graphics.getColorOfRGB(colorR, colorG, colorB));
			g.fillArc(BUTTON_X + 2, BUTTON_Y_3 - 8, 7, 7, 0, 360);
			choice = 3;
		} else {
			g.setColor(Graphics.getColorOfRGB(252, 252, 252));
			g.fillArc(BUTTON_X + 2, BUTTON_Y_3 - 8, 7, 7, 0, 360);
		}
		//�t�H�[�J�X		
		g.setColor(Graphics.getColorOfRGB(colorR, colorG, colorB));
		g.drawString("��1�̓`�F�b�N���Ă��������B", 10, 150);
		g.fillRect(
			x - margin / 2,
			yi[focusedSelect] - f.getHeight() - margin / 2,
			f.stringWidth(menu[focusedSelect]) + margin,
			f.getHeight() + margin);
		//���j���[���ڕ\��
		for (int i = 0; i < menu.length; i++) {
			g.drawString(menu[i], x, yi[i]);
		}
		this.tokuten = tokuten;
		//�t�H�[�J�X�̂������Ă��鍀�ڂ͔������ɂ���
		g.setColor(Graphics.getColorOfName(Graphics.WHITE));
		g.drawString(menu[focusedSelect], x, yi[focusedSelect]);
		//1���`�F�b�N����ĂȂ��Ƃ��̓_�C�A���O�{�b�N�X��\���B
		if ((!check1) && (!check2) && (!check3)) {
			checkFlg = true;
		} else {
			checkFlg = false;
		}
	}
	public void gettokuten(int seikai) {
		//�����Ȃ�p�����[�^�ɓ��_��������B	
		if (seikai == choice) {
			sougoutokuten = sougoutokuten + tokuten;
		}
	}
	private void kekka(Graphics g) {
		g.setColor(Graphics.getColorOfRGB(colorR, colorG, colorB));
		g.fillRect(0, 0, Display.getWidth(), Display.getHeight());
		g.setColor(Graphics.getColorOfRGB(bcolorR, bcolorG, bcolorB));
		g.fillRect(5, 5, Display.getWidth() - 10, Display.getHeight() - 10);
		g.setColor(Graphics.getColorOfRGB(colorR, colorG, colorB));
		g.fillRect(5, 190, 45, 45);
		g.setColor(Graphics.getColorOfRGB(0, 0, 0));
		g.drawRect(5, 190, 45, 45);
		g.drawRect(7, 192, 41, 41);
		g.drawRect(0, 0, Display.getWidth(), Display.getHeight());
		g.drawRect(5, 5, Display.getWidth() - 10, Display.getHeight() - 10);
		g.drawString("���Ȃ��̓��_��", 30, 30);
		if (0 <= sougoutokuten & sougoutokuten <= 25) {
			g.drawString("�S�R���߁E�E�E�B", 30, 100);
			g.drawString("�m�F�̃y�[�W������", 30, 120);
			g.drawString("�o���܂��傤�I�I", 30, 140);
			g.setFont(Font.getFont(Font.TYPE_HEADING));
			g.drawString(sougoutokuten + "�_!!", 30, 70);
			g.drawImage(characterImage[1], 8, Display.getHeight() - 47);
		}
		if (26 <= sougoutokuten & sougoutokuten <= 50) {
			g.drawString("���[��E�E�B����", 30, 100);
			g.drawString("�������Ȃ��Ⴍ���Ȃ��E�E�B", 30, 120);
			g.drawString("�����������", 30, 140);
			g.drawString("�o���܂��傤�I�I", 30, 160);
			g.setFont(Font.getFont(Font.TYPE_HEADING));
			g.drawString(sougoutokuten + "�_!!", 30, 70);
			g.drawImage(characterImage[2], 8, Display.getHeight() - 47);
		}
		if (51 <= sougoutokuten & sougoutokuten <= 75) {
			g.drawString("�Ȃ��Ȃ������ł��I", 30, 100);
			g.drawString("���������Ŋ����ł��I", 30, 120);
			g.setFont(Font.getFont(Font.TYPE_HEADING));
			g.drawString(sougoutokuten + "�_!!", 30, 70);
			g.drawImage(characterImage[3], 8, Display.getHeight() - 47);
		}

		if (76 <= sougoutokuten & sougoutokuten <= 99) {
			g.drawString("�悭�ł��܂����I", 30, 100);
			g.drawString("100�_�܂ł��Ə����ł��B", 30, 120);
			g.setFont(Font.getFont(Font.TYPE_HEADING));
			g.drawString(sougoutokuten + "�_!!", 30, 70);
			g.drawImage(characterImage[4], 8, Display.getHeight() - 47);
		}
		if (sougoutokuten == 100) {
			g.setFont(Font.getFont(Font.TYPE_HEADING));
			g.drawString("Excellence!!!", 30, 100);
			g.drawString(sougoutokuten + "�_!!", 30, 70);
			g.drawImage(characterImage[5], 8, Display.getHeight() - 47);
		}
		switch (shuruiFlg) {
			case 1 :

				if (sougoutokuten > tokutens[0]) {
					tokutens[0] = sougoutokuten;
					saveHiScore();
				}
				break;
			case 2 :
				if (sougoutokuten > tokutens[1]) {
					tokutens[1] = sougoutokuten;
					saveHiScore();
				}
				break;
			case 3 :
				if (sougoutokuten > tokutens[2]) {
					tokutens[2] = sougoutokuten;
					saveHiScore();
				}
				break;
			case 4 :
				if (sougoutokuten > tokutens[3]) {
					tokutens[3] = sougoutokuten;
					saveHiScore();
				}
				break;
			case 5 :
				if (sougoutokuten > tokutens[4]) {
					tokutens[4] = sougoutokuten;
					saveHiScore();
				}
				break;
			case 6 :
				if (sougoutokuten > tokutens[5]) {
					tokutens[5] = sougoutokuten;
					saveHiScore();
				}
				break;
		}
	}
	//�f�f��ʂ̏����I��******************************************************************************************

	public void paint(Graphics g) {
		g.lock();
		g.setFont(Font.getFont(Font.SIZE_TINY));

		g.setColor(Graphics.getColorOfName(Graphics.WHITE)); //�w�i�𔒂ɓh��Ԃ�
		g.fillRect(0, 0, getWidth(), getHeight());

		if (state != INIT
			&& state != INFO
			&& state != MENU) { //��ʉE����Super5S�̃��S��\��
			if (logoImage != null) {
				g.drawImage(
					logoImage,
					getWidth() - logoImage.getWidth() - 5,
					getHeight() - logoImage.getHeight() - 5);
			}
		}
		//��Ԗ��̕`�揈��
		if (state < 10 || state == 99) {
			switch (state) {
				case INIT :
					if (titleImage != null) {
						g.drawImage(
							titleImage,
							(getWidth() - titleImage.getWidth()) / 2,
							(getHeight() - titleImage.getHeight()) / 2);
					}
					break;
				case MENU :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "�I��");
					menu(g);
					break;
				case SINDAN :
					setSoftLabel(Frame.SOFT_KEY_1, "MENU");
					setSoftLabel(Frame.SOFT_KEY_2, "�I��");
					sindan(g);
					break;
				case KAKUNIN :
					setSoftLabel(Frame.SOFT_KEY_1, "MENU");
					setSoftLabel(Frame.SOFT_KEY_2, "�I��");
					kakunin(g);
					break;
				case KEKKA :
					setSoftLabel(Frame.SOFT_KEY_1, "MENU");
					setSoftLabel(Frame.SOFT_KEY_2, "�I��");
					kiroku(g);
					break;
				case KEKKA2 :
					setSoftLabel(Frame.SOFT_KEY_1, "MENU");
					setSoftLabel(Frame.SOFT_KEY_2, "�I��");
					kiroku2(g);
					break;
				case INFO :
					setSoftLabel(Frame.SOFT_KEY_1, "MENU");
					setSoftLabel(Frame.SOFT_KEY_2, "����");
					info(g);
					break;
				case INFO2 :
					setSoftLabel(Frame.SOFT_KEY_1, "�߂�");
					setSoftLabel(Frame.SOFT_KEY_2, "����");
					info2(g);
					break;
				case INFO3 :
					setSoftLabel(Frame.SOFT_KEY_1, "�߂�");
					setSoftLabel(Frame.SOFT_KEY_2, "MENU");
					info3(g);
					break;
				case OPTION :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "����");
					option(g);
					break;

			}
		}
		/******************�m�F��ʏ���********************************************************/
		if (11 <= state && state <= 22) {
			switch (state) {
				case SETUGU_AISATU :
					setSoftLabel(Frame.SOFT_KEY_1, "�߂�");
					setSoftLabel(Frame.SOFT_KEY_2, "����");
					kakuninM(
						"��������",
						"14.�������́A���邭�傫�Ȑ��ŁA",
						"�C�L�C�L�ƁB",
						"15.���q�l�͂������A�Ј����m�A",
						"�֌W�҂ւ̂�������ϋɓI�ɂ��悤�B",
						"16.�������́A���K���B",
						"���������ɂ��悤�B",
						"17.����̖ڂ����āA�Ί�Ƃ����V��",
						"�����Ă��������悤�B",
						"",
						"",
						g);

					break;
				case AISATU2 :
					setSoftLabel(Frame.SOFT_KEY_1, "�߂�");
					setSoftLabel(Frame.SOFT_KEY_2, "MENU");
					kakuninM(
						"�ڋ��V��p��",
						"1.��������Ⴂ�܂�",
						"2.���͂悤�������܂�",
						"3.�������܂�܂���",
						"4.���X���҂�������",
						"5.���҂����������܂���",
						"6.�\���󂲂����܂���",
						"7.���肪�Ƃ��������܂�",
						"",
						"",
						"",
						g);
					break;
				case SETUGU_KOTOBA :
					setSoftLabel(Frame.SOFT_KEY_1, "�߂�");
					setSoftLabel(Frame.SOFT_KEY_2, "����");
					kakuninM(
						"�ڋ��i���t�����j",
						"18.�u�q�v0�_�A�u���q����v30�_�A",
						"�u���q���܁v100�_�B",
						"19.�f���ȋC�����ŁA",
						"�܂��u�͂��v�ƕԎ����悤�B",
						"20.�n�L�n�L�ƁA�_�炩�������ŁA",
						"���������Ęb�����B",
						"21.�P��Řb�����A���͂ŉ�b���悤�B",
						"",
						"",
						"",
						g);
					break;
				case KOTOBA2 :
					setSoftLabel(Frame.SOFT_KEY_1, "�߂�");
					setSoftLabel(Frame.SOFT_KEY_2, "MENU");
					kakuninM(
						"�ڋ��i���t�����j",
						"22.�u�ł��E�܂��v�����Ĕ�����",
						"���t�Řb�����B",
						"23.����̘b�͍Ō�܂ł������蕷���A",
						"���Â��A�������������肵�悤�B",
						"24.���肢�₨�f������鎞��",
						"�N�b�V�������t���g�����B",
						"25.���p��͎g�킸�ɁA",
						"�݂�Ȃ������錾�t�ł��ē����B",
						"",
						"",
						g);
					break;
				case SETUGU_DENWA :
					setSoftLabel(Frame.SOFT_KEY_1, "�߂�");
					setSoftLabel(Frame.SOFT_KEY_2, "����");
					kakuninM(
						"�ڋ��i�d�b���΁j",
						"26.�d�b��3�R�[���ȓ��łƂ낤�B",
						"�i3�R�[���ȏ�̂Ƃ���",
						"�u���҂����������܂����v�ƌ����j",
						"27.�d�b���󂯂鎞�A�����鎞�́A",
						"��Ж��A�����A�������܂��`���悤�B",
						"28.�d�b�ɏo��Ƃ��̐��̃g�[���́A",
						"�h���~�t�@�\�́u�\�v�̉��ŁB",
						"",
						"",
						"",
						g);
					break;
				case DENWA2 :
					setSoftLabel(Frame.SOFT_KEY_1, "�߂�");
					setSoftLabel(Frame.SOFT_KEY_2, "MENU");
					kakuninM(
						"�ڋ��i�d�b���΁j",
						"29.�v���ȉ��΂ƁA�u���X���҂����������v",
						"�u���҂����������܂����v�̈ꐺ��Y�ꂸ�ɁB",
						"30.���҂�������ꍇ�A��莟���ꍇ�́A",
						"�ۗ��������A������̉�b��",
						"����ɕ������Ȃ��悤�z�����悤�B",
						"31.�d�b��؂�Ƃ��́A",
						"���肪�؂��Ă���Â��Ɏ�b���u�����B",
						"",
						"",
						"",
						g);
					break;
				case FOURS :
					setSoftLabel(Frame.SOFT_KEY_1, "�߂�");
					setSoftLabel(Frame.SOFT_KEY_2, "����");
					kakuninM(
						"�����E���ځE�|���E����",
						"1.�����g�̉��́u�����E",
						"���ځE���|�E�����i4S�j�v�����悤�B",
						"2.�SS�̓S���́u�����v��邱�ƁB",
						"�����≘���ςݏd�˂Ȃ����ƁB",
						"3.�N�����Ă��킩��悤�ɁA",
						"�������o����悤�ɐ������ڂ��悤�B",
						"",
						"",
						"",
						"",
						g);
					break;
				case FOURS2 :
					setSoftLabel(Frame.SOFT_KEY_1, "�߂�");
					setSoftLabel(Frame.SOFT_KEY_2, "MENU");
					kakuninM(
						"�����E���ځE�|���E����",
						"4.�Г��̃S�~�́A",
						"�Ј��S���ł�����ŏE�����B",
						"5.��؂Ȃ��q���܂��䂪�Ƃɂ��}������",
						"�C�����ŁA�������|���悤�B",
						"6.�ǂ�ȏ����ȃS�~��������Ȃ��A",
						"�N���������Ȃ��ْ��������C����낤�B",
						"",
						"",
						"",
						"",
						g);
					break;
				case KODO_JOUHOU :
					setSoftLabel(Frame.SOFT_KEY_1, "�߂�");
					setSoftLabel(Frame.SOFT_KEY_2, "����");
					kakuninM(
						"�s���E��񊴓x",
						"32.���q���܂ֈ���ߕt�����B",
						"���q���܂̑O�Ɋ���o�����B",
						"33.�L�r�L�r�A�e�L�p�L�A",
						"�v���ɍs�����悤�B",
						"34.��{�����O�ꂵ�A",
						"�~�X���Ȃ����m�ȃT�[�r�X�����悤�B",
						"35.�L�x�ȋƖ��m���ŁA",
						"�v���Ƃ��Ď��M���鉞�΂����悤�B",
						"",
						"",
						g);
					break;
				case KODO_JOUHOU2 :
					setSoftLabel(Frame.SOFT_KEY_1, "�߂�");
					setSoftLabel(Frame.SOFT_KEY_2, "MENU");
					kakuninM(
						"�s���E��񊴓x",
						"36.���q���܂��猾���Ă���",
						"���̂ł͂Ȃ��A�����炩��",
						"������ňꐺ�����A��񂶂čs�����悤�B",
						"37.���q���܂̐��ɑf���ȋC������",
						"�����X���A���₩�ɕ񍐂��A",
						"�S���ŋ��L���悤�B",
						"39.�u���������q���܂�������",
						"�ǂ����Ă��炢�������v",
						"�Ƃ����l���čs�����悤�B",
						"",
						g);
					break;
				case MIDASINAMI :
					setSoftLabel(Frame.SOFT_KEY_1, "�߂�");
					setSoftLabel(Frame.SOFT_KEY_2, "����");
					kakuninM(
						"�ڋ��E�g�����Ȃ݁E�p���E�\��",
						"7.�S�Ă̐l�ɍD����^����",
						"�����Ȑg�����Ȃ݂ɐ����悤�B",
						"8.�w�؂��s���ƐL�΂��āA",
						"�ǂ��p�����L�[�v���悤�B",
						"9.���΂́A�̂��ނ��āA",
						"�ڐ����ނ��āB",
						"10.���r�����ɉ񂵂���A",
						"�r�g�݂����肹���ɁA���",
						"�̑��ɓY�킹�邩�O�őg�����B",
						"",
						g);
					break;
				case MIDASINAMI2 :
					setSoftLabel(Frame.SOFT_KEY_1, "�߂�");
					setSoftLabel(Frame.SOFT_KEY_2, "MENU");
					kakuninM(
						"�ڋ��E�g�����Ȃ݁E�p���E�\��",
						"11.���q���܃G���A�ł͎��ꌵ�ցB",
						"12.���邢�\��A�D��������A",
						"����₩�ȏΊ���B",
						"13.�ŏ��ƍŌ�́A",
						"�K���A�C�R���^�N�g���Ƃ낤",
						"",
						"",
						"",
						"",
						"",
						g);
					break;
			}
		}
		/******************�m�F��ʏ����I��********************************************************/
		/******************�f�f4�r********************************************************/
		if (41 <= state && state <= 47) {
			switch (state) {
				case SINDAN_FOURS :
					tokuten = 0;
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "����");
					sindanM(
						"�����g�̉��́u�����E",
						"���ځE(�@�@)�E�����i4S�j�v",
						"�����悤�B",
						"1.�|��",
						"2.���|",
						"3.����",
						20,
						g);
					break;
				case SINDAN_FOURS2 :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "����");
					sindanM(
						"�SS�̓S���́u�����v��邱�ƁB",
						"(�@�@)��ςݏd�˂Ȃ����ƁB",
						"",
						"1.������G��",
						"2.������p��",
						"3.�����≘��",
						25,
						g);
					break;
				case SINDAN_FOURS3 :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "����");
					sindanM(
						"�N�����Ă��킩��悤�ɁA",
						"�������o����悤��",
						"(�@�@)���悤�B",
						"1.��������",
						"2.�Y���",
						"3.������",
						8,
						g);
					break;
				case SINDAN_FOURS4 :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "����");
					sindanM(
						"�Г��̃S�~�́A",
						"(�@�@)�ł�����ŏE�����B",
						"",
						"1.�����o�[�S��",
						"2.�Ј��S��",
						"3.�݂��",
						15,
						g);
					break;
				case SINDAN_FOURS5 :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "����");
					sindanM(
						"��؂Ȃ��q���܂�(�@�@)",
						"���}������C�����ŁA",
						"�������|���悤�B",
						"1.�䂪�Ђ�",
						"2.����̉Ƃ�",
						"3.�䂪�Ƃ�",
						8,
						g);
					break;
				case SINDAN_FOURS6 :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "����");
					sindanM(
						"(�@�@)������Ȃ��A",
						"�N���������Ȃ�",
						"�ْ��������C����낤�B",
						"1.�`����",
						"2.�ǂ�ȏ����ȃS�~��",
						"3.�e��S�~��",
						24,
						g);
					break;
				case SINDAN_FOURS_KEKKA :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "����");
					kekka(g);
					break;
			}
		}
		/******************�f�f4�r�I��********************************************************/
		/******************�f�f�g�����Ȃ�********************************************************/
		if (48 <= state && state <= 55) {
			switch (state) {
				case SINDAN_MIDASINAMI :
					tokuten = 0;
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "����");
					sindanM(
						"�S�Ă̐l�ɍD����^����",
						"(�@�@)�g�����Ȃ݂ɐ����悤�B",
						"",
						"1.�J�W���A����",
						"2.������",
						"3.������Ƃ���",
						7,
						g);
					break;
				case SINDAN_MIDASINAMI2 :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "����");
					sindanM(
						"�w�؂��s���ƐL�΂��āA",
						"(�@�@)���L�[�v���悤�B",
						"",
						"1.�ǂ��p��",
						"2.�������p��",
						"3.������Ƃ����p��",
						8,
						g);
					break;
				case SINDAN_MIDASINAMI3 :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "����");
					sindanM(
						"���΂́A(�@�@)�A",
						"�ڐ����ނ��āB",
						"",
						"1.���R�Ƃ���",
						"2.�p���𐳂���",
						"3.�̂��ނ���",
						30,
						g);
					break;
				case SINDAN_MIDASINAMI4 :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "����");
					sindanM(
						"(�@�@)�����ɉ񂵂���A",
						"�r�g�݂����肹���ɁA���",
						"�̑��ɓY�킹�邩�O�őg�����B",
						"1.���r",
						"2.��⑫",
						"3.��",
						15,
						g);
					break;
				case SINDAN_MIDASINAMI5 :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "����");
					sindanM(
						"(�@�@)�ł͎��ꌵ�ցB",
						"",
						"",
						"1.���q���܃G���A",
						"2.���ڎ�",
						"3.�ҍ��ꏊ",
						25,
						g);
					break;
				case SINDAN_MIDASINAMI6 :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "����");
					sindanM(
						"���邢�\��A�D��������A",
						"(�@�@)�ȏΊ���B",
						"",
						"1.����",
						"2.����",
						"3.����₩",
						7,
						g);
					break;
				case SINDAN_MIDASINAMI7 :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "����");
					sindanM(
						"�ŏ��ƍŌ�́A",
						"�K��(�@�@)���Ƃ낤",
						"",
						"1.�ʐ^",
						"2.�A�C�R���^�N�g",
						"3.�ӎv�a��",
						8,
						g);
					break;
				case SINDAN_MIDASINAMI_KEKKA :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "����");
					kekka(g);
					break;
			}
		}
		/******************�f�f�g�����ȂݏI��********************************************************/
		/******************�f�f��������********************************************************/
		if (56 <= state && state <= 60) {
			switch (state) {
				case SINDAN_SETUGU_AISATU :
					tokuten = 0;
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "����");
					sindanM(
						"�������́A���邭(�@�@)�A",
						"�C�L�C�L�ƁB",
						"",
						"1.���C��",
						"2.��_��",
						"3.�傫�Ȑ���",
						28,
						g);
					break;
				case SINDAN_SETUGU_AISATU2 :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "����");
					sindanM(
						"���q�l�͂������A(�@�@)�A",
						"�֌W�҂ւ̂�������",
						"�ϋɓI�ɂ��悤�B",
						"1.�Г���",
						"2.�Ј����m",
						"3.�ЊO�ł�",
						40,
						g);
					break;
				case SINDAN_SETUGU_AISATU3 :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "����");
					sindanM(
						"�������́A(�@�@)�B",
						"���������ɂ��悤�B",
						"",
						"1.���K��",
						"2.���K�s",
						"3.�F������",
						18,
						g);
					break;
				case SINDAN_SETUGU_AISATU4 :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "����");
					sindanM(
						"����̖ڂ����āA�Ί��",
						"(�@�@)�������Ă��������悤�B",
						"",
						"1.�C����",
						"2.���y�Y",
						"3.�����V",
						14,
						g);
					break;
				case SINDAN_SETUGU_AISATU_KEKKA :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "����");
					kekka(g);
					break;
			}
		}
		/******************�f�f�������I��********************************************************/
		/******************�f�f���t�Â���********************************************************/
		if (61 <= state && state <= 69) {
			switch (state) {
				case SINDAN_SETUGU_KOTOBA :
					tokuten = 0;
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "����");
					sindanM(
						"�u�q�v0�_�A�u���q����v",
						"(�@)�_�A�u���q���܁v100�_�B",
						"",
						"1.30",
						"2.50",
						"3.90",
						10,
						g);
					break;
				case SINDAN_SETUGU_KOTOBA2 :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "����");
					sindanM(
						"�f���ȋC�����ŁA",
						"�܂��u(�@�@)�v�ƕԎ����悤�B",
						"",
						"1.������",
						"2.�͂�",
						"3.���肪�Ƃ�",
						9,
						g);
					break;
				case SINDAN_SETUGU_KOTOBA3 :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "����");
					sindanM(
						"(�@�@)�A�_�炩�������ŁA",
						"���������Ęb�����B",
						"",
						"1.�Ă��ς���",
						"2.���C�悭",
						"3.�n�L�n�L��",
						18,
						g);
					break;
				case SINDAN_SETUGU_KOTOBA4 :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "����");
					sindanM(
						"�P��Řb�����A",
						"(�@�@)��b���悤�B",
						"",
						"1.�p�P���",
						"2.���߂�",
						"3.���͂�",
						14,
						g);
					break;
				case SINDAN_SETUGU_KOTOBA5 :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "����");
					sindanM(
						"�u(�@�@)�v�����Ĕ�����",
						"���t�Řb�����B",
						"",
						"1.�ł�����",
						"2.�ł��E�܂�",
						"3.��������",
						14,
						g);
					break;
				case SINDAN_SETUGU_KOTOBA6 :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "����");
					sindanM(
						"����̘b�͍Ō�܂�",
						"�������蕷���A���Â��A",
						"(�@�@)���������肵�悤�B",
						"1.�A�C�R���^�N�g",
						"2.���Ȃ���",
						"3.����",
						17,
						g);
					break;
				case SINDAN_SETUGU_KOTOBA7 :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "����");
					sindanM(
						"���肢�₨�f���",
						"���鎞��(�@�@)���t���g�����B",
						"",
						"1.���J��",
						"2.�N�b�V����",
						"3.�X�|���W",
						8,
						g);
					break;
				case SINDAN_SETUGU_KOTOBA8 :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "����");
					sindanM(
						"(�@�@)�͎g�킸�ɁA",
						"�݂�Ȃ������錾�t��",
						"���ē����B",
						"1.���p��",
						"2.�O����",
						"3.�v���t�F�b�V���i��",
						10,
						g);
					break;
				case SINDAN_SETUGU_KOTOBA_KEKKA :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "����");
					kekka(g);
					break;
			}
		}
		/******************�f�f���t�Â����I��********************************************************/
		/******************�f�f�d�b����********************************************************/
		if (70 <= state && state <= 77) {
			switch (state) {
				case SINDAN_SETUGU_DENWA :
					tokuten = 0;
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "����");
					sindanM(
						"�d�b��3�R�[���ȓ��łƂ낤�B",
						"�i3�R�[���ȏ�̂Ƃ���",
						"(�@�@)�v�ƌ���",
						"1.�҂�������",
						"2.�����܂���",
						"3.���҂����������܂���",
						10,
						g);
					break;
				case SINDAN_SETUGU_DENWA2 :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "����");
					sindanM(
						"�d�b���󂯂鎞�A�����鎞�́A",
						"�����鎞�́A(�@�@)�A",
						"�������܂��`���悤�B",
						"1.��Ж��A����",
						"2.��Ж��A����",
						"3.���ӂ�",
						24,
						g);
					break;
				case SINDAN_SETUGU_DENWA3 :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "����");
					sindanM(
						"�d�b�ɏo��Ƃ��̐���",
						"�g�[���́A�h���~�t�@�\��",
						"�u(�@)�v�̉��ŁB",
						"1.��",
						"2.�\",
						"3.��",
						6,
						g);
					break;
				case SINDAN_SETUGU_DENWA4 :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "����");
					sindanM(
						"�v���ȉ��΂ƁA�u(�@�@)�v",
						"�u���҂����������܂����v��",
						"�ꐺ��Y�ꂸ�ɁB",
						"1.���΂炭���҂���������",
						"2.���X���҂���������",
						"3.������Ƃ܂���",
						22,
						g);
					break;
				case SINDAN_SETUGU_DENWA5 :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "����");
					sindanM(
						"���҂�������ꍇ�A(�@)�A�ۗ�",
						"�������A������̉�b�������",
						"�������Ȃ��悤�z�����悤�B",
						"1.���҂������鎞��",
						"2.��莟���ꍇ��",
						"3.�y���܂���ꍇ��",
						13,
						g);
					break;
				case SINDAN_SETUGU_DENWA6 :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "����");
					sindanM(
						"�d�b��؂�Ƃ��́A",
						"���肪�؂��Ă���(�@�@)",
						"��b���u�����B",
						"1.�Â���",
						"2.������",
						"3.������",
						25,
						g);
					break;
				case SINDAN_SETUGU_DENWA_KEKKA :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "����");
					kekka(g);
					break;
			}
		}
		/******************�f�f�d�b���ΏI��********************************************************/
		/******************�f�f�s����񊴓x********************************************************/
		if (78 <= state && state <= 85) {
			switch (state) {
				case SINDAN_KODO_JOUHOU :
					tokuten = 0;
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "����");
					sindanM(
						"���q���܂�(�@�@)�ߕt�����B",
						"���q���܂̑O�Ɋ���o�����B",
						"",
						"1.�S����",
						"2.������",
						"3.���",
						8,
						g);
					break;
				case SINDAN_KODO_JOUHOU2 :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "����");
					sindanM(
						"(�@�@�@�@)",
						"�v���ɍs�����悤�B",
						"",
						"1.���҂������Ȃ��悤",
						"2.�L�r�L�r�A�e�L�p�L�A",
						"3.������",
						19,
						g);
					break;
				case SINDAN_KODO_JOUHOU3 :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "����");
					sindanM(
						"��{�����O�ꂵ�A",
						"�~�X���Ȃ�(�@�@)�����悤�B",
						"",
						"1.�d��",
						"2.�����ȕ�d",
						"3.���m�ȃT�[�r�X",
						6,
						g);
					break;
				case SINDAN_KODO_JOUHOU4 :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "����");
					sindanM(
						"�L�x�ȋƖ��m���ŁA",
						"(�@�@)�Ƃ��Ď��M����",
						"���΂����悤�B",
						"1.�v��",
						"2.����",
						"3.�B�l",
						5,
						g);
					break;
				case SINDAN_KODO_JOUHOU5 :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "����");
					sindanM(
						"���q���܂��猾���Ă���",
						"���̂ł͂Ȃ��A�����炩��",
						"(�@�@)�A��񂶂čs�����悤�B",
						"1.�Ӑ}�������",
						"2.�b�𕷂�",
						"3.������ňꐺ����",
						33,
						g);
					break;
				case SINDAN_KODO_JOUHOU6 :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "����");
					sindanM(
						"(�@�@)�ɑf���ȋC������",
						"�����X���A���₩��",
						"�񍐂��A�S���ŋ��L���悤�B",
						"1.���q���܂̐�",
						"2.���Ԃ̐�",
						"3.���_",
						16,
						g);
					break;
				case SINDAN_KODO_JOUHOU7 :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "����");
					sindanM(
						"�u������(�@�@)��������",
						"�ǂ����Ă��炢�������v",
						"�Ƃ����l���čs�����悤�B",
						"1.�����",
						"2.����",
						"3.���q����",
						13,
						g);
					break;
				case SINDAN_KODO_JOUHOU_KEKKA :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "����");
					kekka(g);
					break;
			}
		}
		/******************�f�f�s����񊴓x�I��********************************************************/
		g.unlock(true);
	}
	private void menu(Graphics g) {
		g.setColor(Graphics.getColorOfRGB(bcolorR, bcolorG, bcolorB));
		g.fillRect(0, 0, Display.getWidth(), Display.getHeight());
		String title = "MENU";
		String[] menu = { "5S�x�f�f", "5S���m�F", "�f�f���ʂ̋L�^������", "5S�̐���", "OPTION" };
		g.setColor(Graphics.getColorOfRGB(colorR, colorG, colorB));
		//MENU�p�摜�̕\��
		if (logoImage != null) {
			g.drawImage(logoImage, 160, 205);
		}
		if (mImage[0] != null) {
			g.drawImage(mImage[0], 7, 35);
		}
		if (mImage[1] != null) {
			g.drawImage(mImage[1], 176, 55);
		}
		if (mImage[2] != null) {
			g.drawImage(mImage[2], 5, 88);
		}
		if (mImage[3] != null) {
			g.drawImage(mImage[3], 165, 135);
		}
		if (mImage[4] != null) {
			g.drawImage(mImage[4], 5, 150);
		}

		//�^�C�g���\��
		int x = (getWidth() - f.stringWidth(title)) / 2;
		int y = 30;
		g.drawString(title, x, y);
		g.drawLine(x - 2, y + 2, x + f.stringWidth(title) + 2, y + 2);

		x = 60;
		int[] yi = { 60, 100, 140, 180, 220 };

		//�t�H�[�J�X
		g.setColor(Graphics.getColorOfRGB(colorR, colorG, colorB));
		g.fillRect(
			x - margin / 2,
			yi[focusedMenu] - f.getHeight() - margin / 2,
			f.stringWidth(menu[focusedMenu]) + margin,
			f.getHeight() + margin);

		//���j���[���ڕ\��
		for (int i = 0; i < menu.length; i++) {
			g.drawString(menu[i], x, yi[i]);
		}
		//�t�H�[�J�X�̂������Ă��鍀�ڂ͔������ɂ���
		g.setColor(Graphics.getColorOfName(Graphics.WHITE));
		g.drawString(menu[focusedMenu], x, yi[focusedMenu]);
	}
	public void processEvent(int type, int param) {
		if (type == Display.KEY_PRESSED_EVENT) {
			if (param == Display.KEY_SOFT1) {
				if (state < 11) {
					switch (state) {
						case INFO2 :
							state = INFO;
							break;
						case INFO3 :
							state = INFO2;
							break;
						default :
							state = MENU;
							break;
					}
				} else if (11 <= state && state <= 22) {
					switch (state) {
						case SETUGU_AISATU :
							focusedMenuKakunin = 0;
							state = KAKUNIN;
							break;
						case SETUGU_KOTOBA :
							focusedMenuKakunin = 0;
							state = KAKUNIN;
							break;
						case MIDASINAMI :
							focusedMenuKakunin = 0;
							state = KAKUNIN;
							break;
						case SETUGU_DENWA :
							focusedMenuKakunin = 0;
							state = KAKUNIN;
							break;
						case FOURS :
							focusedMenuKakunin = 0;
							state = KAKUNIN;
							break;
						case KODO_JOUHOU :
							focusedMenuKakunin = 0;
							state = KAKUNIN;
							break;
						case AISATU2 :
							focusedMenuKakunin = 0;
							state = SETUGU_AISATU;
							break;
						case KOTOBA2 :
							focusedMenuKakunin = 0;
							state = SETUGU_KOTOBA;
							break;
						case MIDASINAMI2 :
							focusedMenuKakunin = 0;
							state = MIDASINAMI;
							break;
						case DENWA2 :
							focusedMenuKakunin = 0;
							state = SETUGU_DENWA;
							break;
						case FOURS2 :
							focusedMenuKakunin = 0;
							state = FOURS;
							break;
						case KODO_JOUHOU2 :
							focusedMenuKakunin = 0;
							state = KODO_JOUHOU;
							break;
					}
				} else if (state >= 41) {
					switch (state) {
						case OPTION :
							break;
						default :
							break;
					}
				}
			} else if (param == Display.KEY_SOFT2) {
				if (state < 10 || state == 99) {
					switch (state) {
						case INFO :
							state = INFO2;
							break;
						case INFO2 :
							state = INFO3;
							break;
						case INFO3 :
							state = MENU;
							break;
						case OPTION :
							chuuioption(MENU);
							break;
						default :
							IApplication.getCurrentApp().terminate();
							break;
					}
				}
				if (11 <= state && state <= 22) {
					switch (state) {
						case SETUGU_AISATU :
							state = AISATU2;
							break;
						case SETUGU_KOTOBA :
							state = KOTOBA2;
							break;
						case SETUGU_DENWA :
							state = DENWA2;
							break;
						case FOURS :
							state = FOURS2;
							break;
						case KODO_JOUHOU :
							state = KODO_JOUHOU2;
							break;
						case MIDASINAMI :
							state = MIDASINAMI2;
							break;
						default :
							state = KAKUNIN;
							break;
					}
				}
				if (41 <= state && state <= 47) {
					switch (state) {
						case SINDAN_FOURS :
							gettokuten(seikai2);
							chuui(SINDAN_FOURS2);
							break;
						case SINDAN_FOURS2 :
							gettokuten(seikai3);
							chuui(SINDAN_FOURS3);
							break;
						case SINDAN_FOURS3 :
							gettokuten(seikai1);
							chuui(SINDAN_FOURS4);
							break;
						case SINDAN_FOURS4 :
							gettokuten(seikai2);
							chuui(SINDAN_FOURS5);
							break;
						case SINDAN_FOURS5 :
							gettokuten(seikai3);
							chuui(SINDAN_FOURS6);
							break;
						case SINDAN_FOURS6 :
							gettokuten(seikai2);
							chuui(SINDAN_FOURS_KEKKA);
							break;
						case SINDAN_FOURS_KEKKA :
							state = SINDAN;
							break;
					}
				}
				if (48 <= state && state <= 55) {
					switch (state) {
						case SINDAN_MIDASINAMI :
							gettokuten(seikai2);
							chuui(SINDAN_MIDASINAMI2);
							break;
						case SINDAN_MIDASINAMI2 :
							gettokuten(seikai1);
							chuui(SINDAN_MIDASINAMI3);
							break;
						case SINDAN_MIDASINAMI3 :
							gettokuten(seikai3);
							chuui(SINDAN_MIDASINAMI4);
							break;
						case SINDAN_MIDASINAMI4 :
							gettokuten(seikai1);
							chuui(SINDAN_MIDASINAMI5);
							break;
						case SINDAN_MIDASINAMI5 :
							gettokuten(seikai1);
							chuui(SINDAN_MIDASINAMI6);
							break;
						case SINDAN_MIDASINAMI6 :
							gettokuten(seikai3);
							chuui(SINDAN_MIDASINAMI7);
							break;
						case SINDAN_MIDASINAMI7 :
							gettokuten(seikai2);
							chuui(SINDAN_MIDASINAMI_KEKKA);
							break;
						case SINDAN_MIDASINAMI_KEKKA :
							state = SINDAN;
							break;
					}
				}
				if (56 <= state && state <= 60) {
					switch (state) {
						case SINDAN_SETUGU_AISATU :
							gettokuten(seikai3);
							chuui(SINDAN_SETUGU_AISATU2);
							break;
						case SINDAN_SETUGU_AISATU2 :
							gettokuten(seikai2);
							chuui(SINDAN_SETUGU_AISATU3);
							break;
						case SINDAN_SETUGU_AISATU3 :
							gettokuten(seikai1);
							chuui(SINDAN_SETUGU_AISATU4);
							break;
						case SINDAN_SETUGU_AISATU4 :
							gettokuten(seikai3);
							chuui(SINDAN_SETUGU_AISATU_KEKKA);
							break;
						case SINDAN_SETUGU_AISATU_KEKKA :
							state = SINDAN;
							break;
					}
				}
				if (61 <= state && state <= 69) {
					switch (state) {
						case SINDAN_SETUGU_KOTOBA :
							gettokuten(seikai1);
							chuui(SINDAN_SETUGU_KOTOBA2);
							break;
						case SINDAN_SETUGU_KOTOBA2 :
							gettokuten(seikai2);
							chuui(SINDAN_SETUGU_KOTOBA3);
							break;
						case SINDAN_SETUGU_KOTOBA3 :
							gettokuten(seikai3);
							chuui(SINDAN_SETUGU_KOTOBA4);
							break;
						case SINDAN_SETUGU_KOTOBA4 :
							gettokuten(seikai3);
							chuui(SINDAN_SETUGU_KOTOBA5);
							break;
						case SINDAN_SETUGU_KOTOBA5 :
							gettokuten(seikai2);
							chuui(SINDAN_SETUGU_KOTOBA6);
							break;
						case SINDAN_SETUGU_KOTOBA6 :
							gettokuten(seikai3);
							chuui(SINDAN_SETUGU_KOTOBA7);
							break;
						case SINDAN_SETUGU_KOTOBA7 :
							gettokuten(seikai2);
							chuui(SINDAN_SETUGU_KOTOBA8);
							break;
						case SINDAN_SETUGU_KOTOBA8 :
							gettokuten(seikai1);
							chuui(SINDAN_SETUGU_KOTOBA_KEKKA);
							break;
						case SINDAN_SETUGU_KOTOBA_KEKKA :
							state = SINDAN;
							break;
					}
				}
				if (70 <= state && state <= 77) {
					switch (state) {
						case SINDAN_SETUGU_DENWA :
							gettokuten(seikai3);
							chuui(SINDAN_SETUGU_DENWA2);
							break;
						case SINDAN_SETUGU_DENWA2 :
							gettokuten(seikai2);
							chuui(SINDAN_SETUGU_DENWA3);
							break;
						case SINDAN_SETUGU_DENWA3 :
							gettokuten(seikai2);
							chuui(SINDAN_SETUGU_DENWA4);
							break;
						case SINDAN_SETUGU_DENWA4 :
							gettokuten(seikai2);
							chuui(SINDAN_SETUGU_DENWA5);
							break;
						case SINDAN_SETUGU_DENWA5 :
							gettokuten(seikai2);
							chuui(SINDAN_SETUGU_DENWA6);
							break;
						case SINDAN_SETUGU_DENWA6 :
							gettokuten(seikai1);
							chuui(SINDAN_SETUGU_DENWA_KEKKA);
							break;
						case SINDAN_SETUGU_DENWA_KEKKA :
							state = SINDAN;
							break;
					}
				}
				if (78 <= state && state <= 85) {
					switch (state) {
						case SINDAN_KODO_JOUHOU :
							gettokuten(seikai3);
							chuui(SINDAN_KODO_JOUHOU2);
							break;
						case SINDAN_KODO_JOUHOU2 :
							gettokuten(seikai2);
							chuui(SINDAN_KODO_JOUHOU3);
							break;
						case SINDAN_KODO_JOUHOU3 :
							gettokuten(seikai3);
							chuui(SINDAN_KODO_JOUHOU4);
							break;
						case SINDAN_KODO_JOUHOU4 :
							gettokuten(seikai1);
							chuui(SINDAN_KODO_JOUHOU5);
							break;
						case SINDAN_KODO_JOUHOU5 :
							gettokuten(seikai3);
							chuui(SINDAN_KODO_JOUHOU6);
							break;
						case SINDAN_KODO_JOUHOU6 :
							gettokuten(seikai1);
							chuui(SINDAN_KODO_JOUHOU7);
							break;
						case SINDAN_KODO_JOUHOU7 :
							gettokuten(seikai3);
							chuui(SINDAN_KODO_JOUHOU_KEKKA);
							break;
						case SINDAN_KODO_JOUHOU_KEKKA :
							state = SINDAN;
							break;
					}
				}
			} else if (param == Display.KEY_UP) {
				if (state < 41 || state == 99) {
					switch (state) {
						case MENU :
							if (focusedMenu > 0) {
								focusedMenu--;
							} else {
								focusedMenu = MENU_NUM2 - 1;
							}
							break;
						case KAKUNIN :
							if (focusedMenuKakunin > 0) {
								focusedMenuKakunin--;
							} else {
								focusedMenuKakunin = MENU_KAKUNIN_NUM - 1;
							}
							break;
						case SINDAN :
							if (focusedMenuKakunin > 0) {
								focusedMenuKakunin--;
							} else {
								focusedMenuKakunin = MENU_KAKUNIN_NUM - 1;
							}
							break;
						case OPTION :
							if (sfocusedSelecty != 3) {
								sfocusedSelecty = sfocusedSelecty - 3;
							} else {
								sfocusedSelecty = OPTION_MENUY;
							}
							break;
					}
				} else {
					switch (state) {
						default :
							if (focusedSelect > 0) {
								focusedSelect--;
							} else {
								focusedSelect = MENU_SELECT - 1;
							}
							break;

					}
				}
			} else if (param == Display.KEY_DOWN) {
				if (state < 41 || state == 99) {
					switch (state) {
						case MENU :
							if (focusedMenu < MENU_NUM2 - 1) {
								focusedMenu++;
							} else {
								focusedMenu = 0;
							}
							break;
						case KAKUNIN :
							if (focusedMenuKakunin < MENU_KAKUNIN_NUM - 1) {
								focusedMenuKakunin++;
							} else {
								focusedMenuKakunin = 0;
							}
							break;
						case SINDAN :
							if (focusedMenuKakunin < MENU_KAKUNIN_NUM - 1) {
								focusedMenuKakunin++;
							} else {
								focusedMenuKakunin = 0;
							}
							break;
						case OPTION :
							if (sfocusedSelecty < 7) {
								sfocusedSelecty = sfocusedSelecty + 3;
							} else {
								sfocusedSelecty = 3;
							}
							break;
					}
				} else {
					switch (state) {
						default :
							if (focusedSelect < MENU_SELECT - 1) {
								focusedSelect++;
							} else {
								focusedSelect = 0;
							}
							break;
					}
				}
			}
		} else if (param == Display.KEY_RIGHT) {
			switch (state) {
				case OPTION :
					if (sfocusedSelectx < OPTION_MENUX - 1) {
						sfocusedSelectx++;
					} else {
						sfocusedSelectx = 0;
					}
					break;
				default :
					break;
			}
		} else if (param == Display.KEY_LEFT) {

			switch (state) {
				case OPTION :
					if (sfocusedSelectx > 0) {
						sfocusedSelectx--;
					} else {
						sfocusedSelectx = OPTION_MENUX - 1;
					}
					break;
				default :
					break;
			}
		} else if (type == Display.KEY_RELEASED_EVENT) {
			if (param == Display.KEY_SELECT) {
				if (state < 40) {
					switch (state) {
						case MENU :
							switch (focusedMenu) {
								case MENU_SINDAN :
									focusedMenu = 0;
									state = SINDAN;
									break;
								case MENU_KAKUNIN :
									focusedMenu = 0;
									state = KAKUNIN;
									break;
								case MENU_KEKKA :
									focusedMenu = 0;
									state = KEKKA;
									break;
								case MENU_INFO :
									focusedMenu = 0;
									state = INFO;
									break;
								case MENU_OPTION :
									sfocusedSelectx = 0;
									sfocusedSelecty = 3;
									state = OPTION;
									break;
								default :
									break;
							}
							break;
						case KAKUNIN :
							switch (focusedMenuKakunin) {
								case KAKUNIN_MENU_SETUGU_AISATU :
									focusedMenuKakunin = 0;
									state = SETUGU_AISATU;
									break;
								case KAKUNIN_MENU_SETUGU_KOTOBA :
									focusedMenuKakunin = 0;
									state = SETUGU_KOTOBA;
									break;
								case KAKUNIN_MENU_SETUGU_DENWA :
									focusedMenuKakunin = 0;
									state = SETUGU_DENWA;
									break;
								case KAKUNIN_MENU_4S :
									focusedMenuKakunin = 0;
									state = FOURS;
									break;
								case KAKUNIN_MENU_KODO_JOUHOU :
									focusedMenuKakunin = 0;
									state = KODO_JOUHOU;
									break;
								case KAKUNIN_MENU_MIDASINAMI :
									focusedMenuKakunin = 0;
									state = MIDASINAMI;
									break;

								default :
									break;
							}
							break;
						case SINDAN :
							switch (focusedMenuKakunin) {
								case SINDAN_MENU_4S :
									shuruiFlg = 1;
									focusedMenuKakunin = 0;
									state = SINDAN_FOURS;
									break;
								case SINDAN_MENU_MIDASINAMI :
									shuruiFlg = 2;
									focusedMenuKakunin = 0;
									state = SINDAN_MIDASINAMI;
									break;
								case SINDAN_MENU_SETUGU_AISATU :
									shuruiFlg = 3;
									focusedMenuKakunin = 0;
									state = SINDAN_SETUGU_AISATU;
									break;
								case SINDAN_MENU_SETUGU_KOTOBA :
									shuruiFlg = 4;
									focusedMenuKakunin = 0;
									state = SINDAN_SETUGU_KOTOBA;
									break;
								case SINDAN_MENU_SETUGU_DENWA :
									shuruiFlg = 5;
									focusedMenuKakunin = 0;
									state = SINDAN_SETUGU_DENWA;
									break;
								case SINDAN_MENU_KODO_JOUHOU :
									shuruiFlg = 6;
									focusedMenuKakunin = 0;
									state = SINDAN_KODO_JOUHOU;
									break;
								default :
									break;
							}
							break;
						case KEKKA :
							Dialog dialog =
								new Dialog(Dialog.DIALOG_YESNO, "�ō����_�폜");
							dialog.setText("�{���ɍ폜���܂����H");
							if (dialog.show() == Dialog.BUTTON_YES) {
								deleteSave();
								state = KEKKA2;
							}
							break;
					}
				} else {
					switch (state) {
						case OPTION :
							if (focuse < 6) {
								switch (focuse) {
									case 3 :
										if (check1) {
											check1 = false;
										} else {
											check1 = true;
											if (check2) {
												check2 = false;
												check1 = true;
											}
											if (check3) {
												check3 = false;
												check1 = true;
											}
										}

										break;
									case 4 :
										if (check2) {
											check2 = false;
										} else {
											check2 = true;
											if (check1) {
												check1 = false;
												check2 = true;
											}
											if (check3) {
												check3 = false;
												check2 = true;
											}
										}
										break;
									case 5 :
										if (check3) {
											check3 = false;
										} else {
											check3 = true;
											if (check1) {
												check1 = false;
												check3 = true;
											}
											if (check2) {
												check2 = false;
												check3 = true;
											}
											break;
										}
								}
							} else if (5 < focuse && focuse < 9) {
								switch (focuse) {
									case 6 :
										if (check4) {
											check4 = false;
										} else {
											check4 = true;
											if (check5) {
												check5 = false;
												check4 = true;
											}
											if (check6) {
												check6 = false;
												check4 = true;
											}
										}

										break;
									case 7 :
										if (check5) {
											check5 = false;
										} else {
											check5 = true;
											if (check4) {
												check4 = false;
												check5 = true;
											}
											if (check6) {
												check6 = false;
												check5 = true;
											}
										}
										break;
									case 8 :
										if (check6) {
											check6 = false;
										} else {
											check6 = true;
											if (check4) {
												check4 = false;
												check6 = true;
											}
											if (check5) {
												check5 = false;
												check6 = true;
											}
											break;
										}
								}
							} else {
								switch (focuse) {
									case 9 :
										if (check7) {
											check7 = false;
										} else {
											check7 = true;
											if (check8) {
												check8 = false;
												check7 = true;
											}
											if (check9) {
												check9 = false;
												check7 = true;
											}
										}

										break;
									case 10 :
										if (check8) {
											check8 = false;
										} else {
											check8 = true;
											if (check7) {
												check7 = false;
												check8 = true;
											}
											if (check9) {
												check9 = false;
												check8 = true;
											}
										}
										break;
									case 11 :
										if (check9) {
											check9 = false;
										} else {
											check9 = true;
											if (check7) {
												check7 = false;
												check9 = true;
											}
											if (check8) {
												check8 = false;
												check9 = true;
											}
											break;
										}
								}
							}

							break;
						default :
							switch (focusedSelect) {
								case 0 :
									//�`�F�b�N1�Ƀ`�F�b�N�������Ă����炻����͂����A�����łȂ��Ƃ��́A
									//�`�F�b�N�Q�Ƀ`�F�b�N�������Ă�Ƃ��`�F�b�N�P�Ƀ`�F�b�N���ꂽ��A
									//�`�F�b�N�Q�̃`�F�b�N���͂����A�`�F�b�N�P�Ƀ`�F�b�N�����A
									//�`�F�b�N�R�Ƀ`�F�b�N�������Ă���Ƃ��`�F�b�N�P�Ƀ`�F�b�N���ꂽ��A
									//�`�F�b�N�R�̃`�F�b�N���͂����A�`�F�b�N�P�Ƀ`�F�b�N������B

									if (check1) {
										check1 = false;
									} else {
										check1 = true;
										if (check2) {
											check2 = false;
											check1 = true;
										}
										if (check3) {
											check3 = false;
											check1 = true;
										}
									}

									break;
								case 1 :
									if (check2) {
										check2 = false;
									} else {
										check2 = true;
										if (check1) {
											check1 = false;
											check2 = true;
										}
										if (check3) {
											check3 = false;
											check2 = true;
										}
									}
									break;
								case 2 :
									if (check3) {
										check3 = false;
									} else {
										check3 = true;
										if (check2) {
											check2 = false;
											check3 = true;
										}
										if (check1) {
											check1 = false;
											check3 = true;
										}
										break;
									}
							}
							break;

					}
				}
			}
		}
		paint(getGraphics());
	}

}