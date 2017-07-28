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
	int state; //状態遷移フラグ
	//メニュー画面
	final int INIT = 0; //起動時
	final int MENU = 1; //MENU
	final int SINDAN = 2; //5Ｓ診断
	final int KAKUNIN = 3; //5Ｓの確認
	final int KEKKA = 4; //診断の結果を表示＆記録する
	final int INFO = 5; //5Sの説明
	final int KEKKA2 = 6; //診断の結果を表示＆記録する
	final int INFO2 = 7; //5Sの説明
	final int INFO3 = 8; //5Sの説明

	//確認画面のページ(11～39)
	final int SETUGU_AISATU = 11; //接遇（あいさつ）
	final int SETUGU_KOTOBA = 12; //接遇（言葉遣い）
	final int SETUGU_DENWA = 13; //接遇（電話対応）
	final int FOURS = 14; //整理・整頓・掃除・清潔の4Ｓ
	final int KODO_JOUHOU = 15; //行動・情報感度
	final int AISATU2 = 16; //接遇七大用語のページ
	final int KOTOBA2 = 17; //接遇（言葉遣い）2ページ目
	final int DENWA2 = 18; //電話応対2ページ目
	final int FOURS2 = 19; //4S2ページ目
	final int KODO_JOUHOU2 = 20; //行動・情報感度2ページ目
	final int MIDASINAMI = 21; //身だしなみ・姿勢
	final int MIDASINAMI2 = 22; //身だしなみ・姿勢2ページ目
	//診断画面のページ(41～100)
	final int SINDAN_FOURS = 41; //診断画面の4Ｓ
	final int SINDAN_FOURS2 = 42; //診断画面の4Ｓ2ページ目
	final int SINDAN_FOURS3 = 43; //診断画面の4Ｓ3ページ目
	final int SINDAN_FOURS4 = 44; //診断画面の4Ｓ4ページ目
	final int SINDAN_FOURS5 = 45; //診断画面の4Ｓ5ページ目
	final int SINDAN_FOURS6 = 46; //診断画面の4Ｓ6ページ目
	final int SINDAN_FOURS_KEKKA = 47; //診断画面の4Ｓの結果
	//診断画面みだしなみのページ
	final int SINDAN_MIDASINAMI = 48; //診断画面の身だしなみ
	final int SINDAN_MIDASINAMI2 = 49; //診断画面の身だしなみ
	final int SINDAN_MIDASINAMI3 = 50; //診断画面の身だしなみ
	final int SINDAN_MIDASINAMI4 = 51; //診断画面の身だしなみ
	final int SINDAN_MIDASINAMI5 = 52; //診断画面の身だしなみ
	final int SINDAN_MIDASINAMI6 = 53; //診断画面の身だしなみ
	final int SINDAN_MIDASINAMI7 = 54; //診断画面の身だしなみ
	final int SINDAN_MIDASINAMI_KEKKA = 55;

	//診断画面のあいさつのページ
	final int SINDAN_SETUGU_AISATU = 56; //診断画面のあいさつ
	final int SINDAN_SETUGU_AISATU2 = 57;
	final int SINDAN_SETUGU_AISATU3 = 58;
	final int SINDAN_SETUGU_AISATU4 = 59;
	final int SINDAN_SETUGU_AISATU_KEKKA = 60;

	//	診断画面の言葉のページ
	final int SINDAN_SETUGU_KOTOBA = 61; //診断画面の言葉遣い
	final int SINDAN_SETUGU_KOTOBA2 = 62;
	final int SINDAN_SETUGU_KOTOBA3 = 63;
	final int SINDAN_SETUGU_KOTOBA4 = 64;
	final int SINDAN_SETUGU_KOTOBA5 = 65;
	final int SINDAN_SETUGU_KOTOBA6 = 66;
	final int SINDAN_SETUGU_KOTOBA7 = 67;
	final int SINDAN_SETUGU_KOTOBA8 = 68;
	final int SINDAN_SETUGU_KOTOBA_KEKKA = 69;

	//診断画面の電話のページ
	final int SINDAN_SETUGU_DENWA = 70; //診断画面の電話応対	
	final int SINDAN_SETUGU_DENWA2 = 71;
	final int SINDAN_SETUGU_DENWA3 = 72;
	final int SINDAN_SETUGU_DENWA4 = 73;
	final int SINDAN_SETUGU_DENWA5 = 74;
	final int SINDAN_SETUGU_DENWA6 = 75;
	final int SINDAN_SETUGU_DENWA7 = 76;
	final int SINDAN_SETUGU_DENWA_KEKKA = 77;

	//診断画面の行動情報感度のページ
	final int SINDAN_KODO_JOUHOU = 78; //診断画面の行動情報感度
	final int SINDAN_KODO_JOUHOU2 = 79;
	final int SINDAN_KODO_JOUHOU3 = 80;
	final int SINDAN_KODO_JOUHOU4 = 81;
	final int SINDAN_KODO_JOUHOU5 = 82;
	final int SINDAN_KODO_JOUHOU6 = 83;
	final int SINDAN_KODO_JOUHOU7 = 84;
	final int SINDAN_KODO_JOUHOU_KEKKA = 85;

	//オプションのページ
	final int OPTION = 99; //オプション画面
	//MENU
	final int MENU_SINDAN = 0; //診断
	final int MENU_KAKUNIN = 1; //確認
	final int MENU_KEKKA = 2; //結果
	final int MENU_INFO = 3; //説明
	final int MENU_OPTION = 4; //オプション
	final int MENU_NUM = 6;
	final int MENU_NUM2 = 5;
	final int MENU_KAKUNIN_NUM = 6;
	final int OPTION_MENUY = 9;
	final int OPTION_MENUX = 3;
	final int MENU_SELECT = 3;
	//KAKUNIN_MENU
	final int KAKUNIN_MENU_4S = 0; //整理・整頓・掃除・清潔の4Ｓ
	final int KAKUNIN_MENU_MIDASINAMI = 1; //身だしなみ・姿勢	
	final int KAKUNIN_MENU_SETUGU_AISATU = 2; //接遇（あいさつ）
	final int KAKUNIN_MENU_SETUGU_KOTOBA = 3; //接遇（言葉遣い）
	final int KAKUNIN_MENU_SETUGU_DENWA = 4; //接遇（電話対応）
	final int KAKUNIN_MENU_KODO_JOUHOU = 5; //行動・情報感度
	//	SINDAN_MENU
	final int SINDAN_MENU_4S = 0; //整理・整頓・掃除・清潔の4Ｓ
	final int SINDAN_MENU_MIDASINAMI = 1; //身だしなみ・姿勢	
	final int SINDAN_MENU_SETUGU_AISATU = 2; //接遇（あいさつ）
	final int SINDAN_MENU_SETUGU_KOTOBA = 3; //接遇（言葉遣い）
	final int SINDAN_MENU_SETUGU_DENWA = 4; //接遇（電話対応）
	final int SINDAN_MENU_KODO_JOUHOU = 5; //行動・情報感度

	//ボタン位置
	final int BUTTON_X = 210;
	final int BUTTON_Y_1 = 30;
	final int BUTTON_Y_2 = 70;
	final int BUTTON_Y_3 = 110;
	//ボタンのチェックが入っているか否か
	private boolean check1 = false;
	private boolean check2 = false;
	private boolean check3 = false;
	private boolean check4 = false;
	private boolean check5 = false;
	private boolean check6 = false;
	private boolean check7 = false;
	private boolean check8 = false;
	private boolean check9 = false;
	//得点の種類のフラグ
	private int shuruiFlg = 0;
	//正解の判定に使うパラメータ。
	private int seikai1 = 1;
	private int seikai2 = 2;
	private int seikai3 = 3;
	//最低1つチェックが入っているかのフラグ
	private boolean checkFlg = false;
	private boolean checkFlg1 = false;
	private boolean checkFlg2 = false;
	private boolean checkFlg3 = false;
	int focusedMenu; //MENUのフォーカス位置
	int focusedSelect; //SelectMENUのフォーカス位置
	int focusedMenuKakunin; //診断・確認MENUのフォーカス位置	
	//キャラパラメータ
	private int m = 0;
	//Ｘ軸フォーカスＹ軸フォーカス位置を合わせた変数
	private int focuse = 0;
	//X軸Y軸フォーカス位置
	private int sfocusedSelectx;
	private int sfocusedSelecty;
	//ボタン
	private int BUTTONX1 = 20;
	private int BUTTONX2 = 80;
	private int BUTTONX3 = 150;
	private int BUTTONY1 = 60;
	private int BUTTONY2 = 130;
	private int BUTTONY3 = 200;
	//得点
	private int tokuten = 0;
	//総合得点
	private int sougoutokuten = 0;
	//基本色の変数
	private int colorR;
	private int colorG;
	private int colorB;
	//背景色の変数
	private int bcolorR;
	private int bcolorG;
	private int bcolorB;
	/** 表示するメッセージの文字列 */
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
	//得点の数
	final int TOKUTEN_NUM = 6;
	//得点を格納する変数
	private int tokutens[] = new int[6];
	//選んだ項目
	private int choice = 0;
	Font f;
	final int margin = 10;
	final int arrowSize = 5;
	//スクラッチパッドを読み込んだときのキャラクターフラグ0:亀1:男の子2:女の子
	private int characterFlg = 0;
	//最高得点の削除フラグ
	private int deleteFlg = 0;
	//	タイトル、ロゴ、MENU画像
	MediaImage titleMI;
	Image titleImage;
	MediaImage logoMI;
	Image logoImage;
	MediaImage[] mMI;
	Image[] mImage;
	//	キャラ画像
	MediaImage[] kame1MI;
	MediaImage[] otoko1MI;
	MediaImage[] onna1MI;
	Image[] characterImage;
	FSDisplay() {
		state = INIT;
		mMI = new MediaImage[MENU_NUM - 1]; //Super5Sの説明についてはロゴを使うためMENU_NUM-1
		mImage = new Image[MENU_NUM - 1];
		f = Font.getDefaultFont(); // フォントの設定		
	}
	int focusedTokuten; //得点のフォーカス位置
	int[] focusedIndex = new int[10]; //得点を示す	
	public void init() {
		loadHiscore();
		loadOption();
		//タイトルロゴ画像読込み
		if (titleMI == null) {
			titleMI = MediaManager.getImage("resource:///5StTitle.gif");
			try {
				titleMI.use();
			} catch (Exception e) {
			}
			titleImage = titleMI.getImage();
		}
		//タイトルロゴ画像読込み
		if (logoMI == null) {
			logoMI = MediaManager.getImage("resource:///5SLogo.gif");
			try {
				logoMI.use();
			} catch (Exception e) {
			}
			logoImage = logoMI.getImage();
		}
		//MENU画像の読込み
		for (int i = 0; i < MENU_NUM - 1; i++) {
			mMI[i] = MediaManager.getImage("resource:///m" + i + ".gif");
			try {
				mMI[i].use();
			} catch (Exception e) {
			}
			mImage[i] = mMI[i].getImage();
		}
		//配列の準備
		kame1MI = new MediaImage[6];
		otoko1MI = new MediaImage[6];
		onna1MI = new MediaImage[6];
		characterImage = new Image[6];
		//デフォルトではキャラクターとして亀を使う。
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
	 * ハイスコアをロードする	
	 */
	private void loadHiscore() {
		int pos = 0;
		//スクラッチパッドからのデータの読込み
		try {
			for (int i = 0; i < 6; i++) {
				DataInputStream in =
					Connector.openDataInputStream("scratchpad:///0;pos=" + pos);
				if (in.readByte() == 1) {
					//スクラッチパッドに保存されているハイスコアをロードする
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
	 * ハイスコアをスクラッチパッドに保存する
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
	 * ハイスコアを削除する
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
	 * オプションデータををロードする	
	 */
	private void loadOption() {
		//スクラッチパッドからのデータの読込み
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
		//キャラクターに関してはフラグで処理
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
	 * オプションデータをスクラッチパッドに保存する
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
	/** 注意ダイアログボックスを表示する **/
	private void chuui(int joutai) {
		if (checkFlg) {
			Dialog d = new Dialog(Dialog.DIALOG_ERROR, "注意");
			d.setText("最低1つはチェックしてね！");
			d.show();
		} else {
			//フラグを初期化する。
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
					Dialog d = new Dialog(Dialog.DIALOG_ERROR, "注意");
					d.setText("チェックが\n全部抜けています。");
					d.show();
				} else {
					Dialog d = new Dialog(Dialog.DIALOG_ERROR, "注意");
					d.setText("キャラ選択と色選択の\nチェックが抜けてます。");
					d.show();
				}
			} else {
				if (checkFlg3) {
					Dialog d = new Dialog(Dialog.DIALOG_ERROR, "注意");
					d.setText("キャラ選択と背景色選択の\nチェックが抜けてます。");
					d.show();
				} else {
					Dialog d = new Dialog(Dialog.DIALOG_ERROR, "注意");
					d.setText("キャラ選択のチェックが\n抜けてます。");
					d.show();
				}
			}
		} else {
			if (checkFlg2) {
				if (checkFlg3) {
					Dialog d = new Dialog(Dialog.DIALOG_ERROR, "注意");
					d.setText("色と背景色選択の\nチェックが抜けてます。");
					d.show();
				} else {
					Dialog d = new Dialog(Dialog.DIALOG_ERROR, "注意");
					d.setText("色のチェックが\n抜けてます。");
					d.show();
				}
			} else {
				if (checkFlg3) {
					Dialog d = new Dialog(Dialog.DIALOG_ERROR, "注意");
					d.setText("背景色選択の\nチェックが抜けてます。");
					d.show();
				} else {
					//フラグを初期化する。
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
		//ボタンの枠を描画1列目
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
		//ボタンの枠を描画２列目
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
		//ボタンの枠を描画３列目
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
		g.drawString("キャラ選択", 10, 18);
		g.drawString("基本色選択", 10, 90);
		g.drawString("背景色選択", 10, 164);
		String[] menu =
			{
				"",
				"",
				"",
				"1.亀",
				"2.男の子",
				"3.女の子",
				"1.赤",
				"2.緑",
				"3.青",
				"1.薄赤",
				"2.薄緑",
				"3.薄黄" };
		int x = 10;
		int y = 30;
		int[] yi = new int[10];
		yi[3] = BUTTONY1;
		yi[6] = BUTTONY2;
		yi[9] = BUTTONY3;
		int[] xi = { BUTTONX1, BUTTONX2, BUTTONX3 };
		//チェックの処理1列目
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
		//チェックの処理2列目
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
		//チェックの処理3列目
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
		//フォーカス
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
		//フォーカスのあたっている項目は白文字にする
		g.setColor(Graphics.getColorOfName(Graphics.WHITE));
		g.drawString(
			menu[sfocusedSelectx + sfocusedSelecty],
			xi[sfocusedSelectx],
			yi[sfocusedSelecty]);

		//とりあえず、全ての画像データを不使用にして破棄する。
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
		//チェック１ならキャラクターに亀を、2なら男、3なら女
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
		//基本色を入れる。
		//赤のとき
		if (check4) {
			colorR = 252;
			colorG = 127;
			colorB = 127;
		}
		//緑のとき
		if (check5) {
			colorR = 46;
			colorG = 139;
			colorB = 87;
		}
		//青のとき
		if (check6) {
			colorR = 30;
			colorG = 144;
			colorB = 255;
		}
		//背景色を入れる。
		//赤のとき
		if (check7) {
			bcolorR = 255;
			bcolorG = 240;
			bcolorB = 255;
		}
		//緑のとき
		if (check8) {
			bcolorR = 194;
			bcolorG = 255;
			bcolorB = 197;
		}
		//黄色のとき
		if (check9) {
			bcolorR = 255;
			bcolorG = 255;
			bcolorB = 239;
		}
		//1つもチェックされてないときはダイアログボックスを表示。
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
		g.drawString("※全て1つはチェックしてください。", 10, 230);
		saveOption();
	}
	//記録画面の処理**********************************************************************************************

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
		g.drawString("結果", 100, 30);
		g.drawString("整理・整頓・掃除・清掃", 10, 60);
		g.drawString("接遇・身だしなみ・姿勢・表情", 10, 90);
		g.drawString("接遇（あいさつ）", 10, 120);
		g.drawString("接遇（言葉遣い）", 10, 150);
		g.drawString("接遇（電話応対）", 10, 180);
		g.drawString("行動・情報感度", 10, 210);
		g.drawString(tokutens[0] + "点", 203, 60);
		g.drawString(tokutens[1] + "点", 203, 90);
		g.drawString(tokutens[2] + "点", 203, 120);
		g.drawString(tokutens[3] + "点", 203, 150);
		g.drawString(tokutens[4] + "点", 203, 180);
		g.drawString(tokutens[5] + "点", 203, 210);
		g.setColor(Graphics.getColorOfRGB(colorR, colorG, colorB));
		g.fillRect(18, 214, 162, 15);
		g.setColor(Graphics.getColorOfName(Graphics.WHITE));
		g.drawString("※決定ボタンで全得点を削除", 20, 226);

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
		g.drawString("結果", 100, 30);
		g.drawString("整理・整頓・掃除・清掃", 10, 60);
		g.drawString("接遇・身だしなみ・姿勢・表情", 10, 90);
		g.drawString("接遇（あいさつ）", 10, 120);
		g.drawString("接遇（言葉遣い）", 10, 150);
		g.drawString("接遇（電話応対）", 10, 180);
		g.drawString("行動・情報感度", 10, 210);
		g.drawString("0点", 203, 60);
		g.drawString("0点", 203, 90);
		g.drawString("0点", 203, 120);
		g.drawString("0点", 203, 150);
		g.drawString("0点", 203, 180);
		g.drawString("0点", 203, 210);
	}
	//記録画面の処理終了******************************************************************************************
	//確認画面の処理**********************************************************************************************
	private void kakunin(Graphics g) {
		String title = "確認MENU";
		String[] menu2 =
			{
				"整理・整頓・掃除・清掃",
				"接遇・身だしなみ・姿勢・表情",
				"接遇（あいさつ）",
				"接遇（言葉遣い）",
				"接遇（電話応対）",
				"行動・情報感度" };
		g.setColor(Graphics.getColorOfRGB(bcolorR, bcolorG, bcolorB));
		g.fillRect(0, 0, Display.getWidth(), Display.getHeight());
		//タイトル表示		
		int x = (getWidth() - f.stringWidth(title)) / 2;
		int y = 30;
		g.setColor(Graphics.getColorOfRGB(colorR, colorG, colorB));
		g.drawString(title, x, y);
		g.drawLine(x - 2, y + 2, x + f.stringWidth(title) + 2, y + 2);

		x = 60;
		int[] yi = { 50, 80, 110, 140, 170, 200 };

		//フォーカス
		g.setColor(Graphics.getColorOfRGB(colorR, colorG, colorB));
		g.fillRect(
			x - margin / 2,
			yi[focusedMenuKakunin] - f.getHeight() - margin / 2,
			f.stringWidth(menu2[focusedMenuKakunin]) + margin,
			f.getHeight() + margin);

		//メニュー項目表示
		for (int i = 0; i < menu2.length; i++) {
			g.drawString(menu2[i], x, yi[i]);
		}
		//フォーカスのあたっている項目は白文字にする
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
		g.drawString("整理、整頓、清掃、", 12, 110);
		g.drawString("清潔、躾の５つの頭文字「Ｓ」をとって", 12, 130);
		g.drawString("５Ｓと呼ばれています。正しいものを、", 12, 150);
		g.drawString("正しい数だけ、正しいところにの", 12, 170);
		g.drawString("３正にも繋がるとてもよいものなんです。", 12, 190);
		g.drawString("", 12, 210);
	}
	private void info2(Graphics g) {
		g.setColor(Graphics.getColorOfRGB(bcolorR, bcolorG, bcolorB));
		g.fillRect(0, 0, Display.getWidth(), Display.getHeight());
		g.setColor(Graphics.getColorOfRGB(colorR, colorG, colorB));
		g.drawString("1.5S度診断", 12, 20);
		g.drawString("5Sをどれだけ覚え", 40, 40);
		g.drawString("てるかを診断します。", 40, 60);
		g.drawString("2.5Sを確認", 12, 90);
		g.drawString("旅行にいってるときも", 40, 110);
		g.drawString("出張にいってるときも", 40, 130);
		g.drawString("いつでも5Sが確認できます。", 40, 150);
		g.drawString("3.診断結果の記録を見る", 12, 180);
		g.drawString("最高得点を表示します。", 40, 200);
		g.drawString("決定ボタンで全得点を削除できます。", 40, 220);
	}
	private void info3(Graphics g) {
		g.setColor(Graphics.getColorOfRGB(bcolorR, bcolorG, bcolorB));
		g.fillRect(0, 0, Display.getWidth(), Display.getHeight());
		g.setColor(Graphics.getColorOfRGB(colorR, colorG, colorB));
		g.drawString("4.5Sの説明", 12, 20);
		g.drawString("5Sそのものと各機能の", 40, 40);
		g.drawString("説明をします。ここのことです。", 40, 60);
		g.drawString("5.OPTION", 12, 90);
		g.drawString("キャラ選択では、亀、", 40, 110);
		g.drawString("男の子、女の子が選択できます。", 40, 130);
		g.drawString("基本色は赤、緑、青を選択できます。", 40, 150);
		g.drawString("背景色は薄赤、薄緑、薄黄を", 40, 170);
		g.drawString("選択できます。", 40, 190);
		g.drawString("全てチェックしないと", 40, 210);
		g.drawString("次へ進ませません。", 40, 230);
	}
	//確認画面の処理終了******************************************************************************************

	//診断画面の処理**********************************************************************************************
	private void sindan(Graphics g) {
		tokuten = 0;
		sougoutokuten = 0;
		String title = "診断MENU";
		String[] menu2 =
			{
				"整理・整頓・掃除・清掃",
				"接遇・身だしなみ・姿勢・表情",
				"接遇（あいさつ）",
				"接遇（言葉遣い）",
				"接遇（電話応対）",
				"行動・情報感度" };
		g.setColor(Graphics.getColorOfRGB(bcolorR, bcolorG, bcolorB));
		g.fillRect(0, 0, Display.getWidth(), Display.getHeight());
		//タイトル表示
		int x = (getWidth() - f.stringWidth(title)) / 2;
		int y = 30;
		g.setColor(Graphics.getColorOfRGB(colorR, colorG, colorB));
		g.drawString(title, x, y);
		g.drawLine(x - 2, y + 2, x + f.stringWidth(title) + 2, y + 2);

		x = 60;
		int[] yi = { 50, 80, 110, 140, 170, 200 };

		//フォーカス
		g.setColor(Graphics.getColorOfRGB(colorR, colorG, colorB));
		g.fillRect(
			x - margin / 2,
			yi[focusedMenuKakunin] - f.getHeight() - margin / 2,
			f.stringWidth(menu2[focusedMenuKakunin]) + margin,
			f.getHeight() + margin);

		//メニュー項目表示
		for (int i = 0; i < menu2.length; i++) {
			g.drawString(menu2[i], x, yi[i]);
		}
		//フォーカスのあたっている項目は白文字にする
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
		//フォーカス		
		g.setColor(Graphics.getColorOfRGB(colorR, colorG, colorB));
		g.drawString("※1つはチェックしてください。", 10, 150);
		g.fillRect(
			x - margin / 2,
			yi[focusedSelect] - f.getHeight() - margin / 2,
			f.stringWidth(menu[focusedSelect]) + margin,
			f.getHeight() + margin);
		//メニュー項目表示
		for (int i = 0; i < menu.length; i++) {
			g.drawString(menu[i], x, yi[i]);
		}
		this.tokuten = tokuten;
		//フォーカスのあたっている項目は白文字にする
		g.setColor(Graphics.getColorOfName(Graphics.WHITE));
		g.drawString(menu[focusedSelect], x, yi[focusedSelect]);
		//1つもチェックされてないときはダイアログボックスを表示。
		if ((!check1) && (!check2) && (!check3)) {
			checkFlg = true;
		} else {
			checkFlg = false;
		}
	}
	public void gettokuten(int seikai) {
		//正解ならパラメータに得点を代入する。	
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
		g.drawString("あなたの得点は", 30, 30);
		if (0 <= sougoutokuten & sougoutokuten <= 25) {
			g.drawString("全然だめ・・・。", 30, 100);
			g.drawString("確認のページを見て", 30, 120);
			g.drawString("覚えましょう！！", 30, 140);
			g.setFont(Font.getFont(Font.TYPE_HEADING));
			g.drawString(sougoutokuten + "点!!", 30, 70);
			g.drawImage(characterImage[1], 8, Display.getHeight() - 47);
		}
		if (26 <= sougoutokuten & sougoutokuten <= 50) {
			g.drawString("うーん・・。微妙", 30, 100);
			g.drawString("高くもなく低くもなく・・。", 30, 120);
			g.drawString("もうちょっと", 30, 140);
			g.drawString("覚えましょう！！", 30, 160);
			g.setFont(Font.getFont(Font.TYPE_HEADING));
			g.drawString(sougoutokuten + "点!!", 30, 70);
			g.drawImage(characterImage[2], 8, Display.getHeight() - 47);
		}
		if (51 <= sougoutokuten & sougoutokuten <= 75) {
			g.drawString("なかなかいいです！", 30, 100);
			g.drawString("もう少しで完璧です！", 30, 120);
			g.setFont(Font.getFont(Font.TYPE_HEADING));
			g.drawString(sougoutokuten + "点!!", 30, 70);
			g.drawImage(characterImage[3], 8, Display.getHeight() - 47);
		}

		if (76 <= sougoutokuten & sougoutokuten <= 99) {
			g.drawString("よくできました！", 30, 100);
			g.drawString("100点まであと少しです。", 30, 120);
			g.setFont(Font.getFont(Font.TYPE_HEADING));
			g.drawString(sougoutokuten + "点!!", 30, 70);
			g.drawImage(characterImage[4], 8, Display.getHeight() - 47);
		}
		if (sougoutokuten == 100) {
			g.setFont(Font.getFont(Font.TYPE_HEADING));
			g.drawString("Excellence!!!", 30, 100);
			g.drawString(sougoutokuten + "点!!", 30, 70);
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
	//診断画面の処理終了******************************************************************************************

	public void paint(Graphics g) {
		g.lock();
		g.setFont(Font.getFont(Font.SIZE_TINY));

		g.setColor(Graphics.getColorOfName(Graphics.WHITE)); //背景を白に塗りつぶし
		g.fillRect(0, 0, getWidth(), getHeight());

		if (state != INIT
			&& state != INFO
			&& state != MENU) { //画面右下にSuper5Sのロゴを表示
			if (logoImage != null) {
				g.drawImage(
					logoImage,
					getWidth() - logoImage.getWidth() - 5,
					getHeight() - logoImage.getHeight() - 5);
			}
		}
		//状態毎の描画処理
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
					setSoftLabel(Frame.SOFT_KEY_2, "終了");
					menu(g);
					break;
				case SINDAN :
					setSoftLabel(Frame.SOFT_KEY_1, "MENU");
					setSoftLabel(Frame.SOFT_KEY_2, "終了");
					sindan(g);
					break;
				case KAKUNIN :
					setSoftLabel(Frame.SOFT_KEY_1, "MENU");
					setSoftLabel(Frame.SOFT_KEY_2, "終了");
					kakunin(g);
					break;
				case KEKKA :
					setSoftLabel(Frame.SOFT_KEY_1, "MENU");
					setSoftLabel(Frame.SOFT_KEY_2, "終了");
					kiroku(g);
					break;
				case KEKKA2 :
					setSoftLabel(Frame.SOFT_KEY_1, "MENU");
					setSoftLabel(Frame.SOFT_KEY_2, "終了");
					kiroku2(g);
					break;
				case INFO :
					setSoftLabel(Frame.SOFT_KEY_1, "MENU");
					setSoftLabel(Frame.SOFT_KEY_2, "次へ");
					info(g);
					break;
				case INFO2 :
					setSoftLabel(Frame.SOFT_KEY_1, "戻る");
					setSoftLabel(Frame.SOFT_KEY_2, "次へ");
					info2(g);
					break;
				case INFO3 :
					setSoftLabel(Frame.SOFT_KEY_1, "戻る");
					setSoftLabel(Frame.SOFT_KEY_2, "MENU");
					info3(g);
					break;
				case OPTION :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "決定");
					option(g);
					break;

			}
		}
		/******************確認画面処理********************************************************/
		if (11 <= state && state <= 22) {
			switch (state) {
				case SETUGU_AISATU :
					setSoftLabel(Frame.SOFT_KEY_1, "戻る");
					setSoftLabel(Frame.SOFT_KEY_2, "次へ");
					kakuninM(
						"あいさつ",
						"14.あいさつは、明るく大きな声で、",
						"イキイキと。",
						"15.お客様はもちろん、社員同士、",
						"関係者へのあいさつを積極的にしよう。",
						"16.あいさつは、先手必勝。",
						"自分から先にしよう。",
						"17.相手の目を見て、笑顔とお辞儀を",
						"そえてあいさつしよう。",
						"",
						"",
						g);

					break;
				case AISATU2 :
					setSoftLabel(Frame.SOFT_KEY_1, "戻る");
					setSoftLabel(Frame.SOFT_KEY_2, "MENU");
					kakuninM(
						"接遇７大用語",
						"1.いらっしゃいませ",
						"2.おはようございます",
						"3.かしこまりました",
						"4.少々お待ち下さい",
						"5.お待たせいたしました",
						"6.申し訳ございません",
						"7.ありがとうございます",
						"",
						"",
						"",
						g);
					break;
				case SETUGU_KOTOBA :
					setSoftLabel(Frame.SOFT_KEY_1, "戻る");
					setSoftLabel(Frame.SOFT_KEY_2, "次へ");
					kakuninM(
						"接遇（言葉遣い）",
						"18.「客」0点、「お客さん」30点、",
						"「お客さま」100点。",
						"19.素直な気持ちで、",
						"まず「はい」と返事しよう。",
						"20.ハキハキと、柔らかい口調で、",
						"落ち着いて話そう。",
						"21.単語で話さず、文章で会話しよう。",
						"",
						"",
						"",
						g);
					break;
				case KOTOBA2 :
					setSoftLabel(Frame.SOFT_KEY_1, "戻る");
					setSoftLabel(Frame.SOFT_KEY_2, "MENU");
					kakuninM(
						"接遇（言葉遣い）",
						"22.「です・ます」をつけて美しい",
						"言葉で話そう。",
						"23.相手の話は最後までしっかり聞き、",
						"相づち、復唱をしっかりしよう。",
						"24.お願いやお断りをする時は",
						"クッション言葉を使おう。",
						"25.専門用語は使わずに、",
						"みんなが分かる言葉でご案内を。",
						"",
						"",
						g);
					break;
				case SETUGU_DENWA :
					setSoftLabel(Frame.SOFT_KEY_1, "戻る");
					setSoftLabel(Frame.SOFT_KEY_2, "次へ");
					kakuninM(
						"接遇（電話応対）",
						"26.電話は3コール以内でとろう。",
						"（3コール以上のときは",
						"「お待たせいたしました」と言う）",
						"27.電話を受ける時、かける時は、",
						"会社名、所属、氏名をまず伝えよう。",
						"28.電話に出るときの声のトーンは、",
						"ドレミファソの「ソ」の音で。",
						"",
						"",
						"",
						g);
					break;
				case DENWA2 :
					setSoftLabel(Frame.SOFT_KEY_1, "戻る");
					setSoftLabel(Frame.SOFT_KEY_2, "MENU");
					kakuninM(
						"接遇（電話応対）",
						"29.迅速な応対と、「少々お待ちください」",
						"「お待たせいたしました」の一声を忘れずに。",
						"30.お待たせする場合、取り次ぐ場合は、",
						"保留をかけ、こちらの会話が",
						"相手に聞こえないよう配慮しよう。",
						"31.電話を切るときは、",
						"相手が切ってから静かに受話器を置こう。",
						"",
						"",
						"",
						g);
					break;
				case FOURS :
					setSoftLabel(Frame.SOFT_KEY_1, "戻る");
					setSoftLabel(Frame.SOFT_KEY_2, "次へ");
					kakuninM(
						"整理・整頓・掃除・清潔",
						"1.いつも身の回りの「整理・",
						"整頓・清掃・清潔（4S）」をしよう。",
						"2.４Sの鉄則は「すぐ」やること。",
						"資料や汚れを積み重ねないこと。",
						"3.誰が見てもわかるように、",
						"すぐ取り出せるように整理整頓しよう。",
						"",
						"",
						"",
						"",
						g);
					break;
				case FOURS2 :
					setSoftLabel(Frame.SOFT_KEY_1, "戻る");
					setSoftLabel(Frame.SOFT_KEY_2, "MENU");
					kakuninM(
						"整理・整頓・掃除・清潔",
						"4.社内のゴミは、",
						"社員全員ですすんで拾おう。",
						"5.大切なお客さまを我が家にお迎えする",
						"気持ちで、毎日清掃しよう。",
						"6.どんな小さなゴミも汚れもない、",
						"誰もが汚せない緊張感ある空気を作ろう。",
						"",
						"",
						"",
						"",
						g);
					break;
				case KODO_JOUHOU :
					setSoftLabel(Frame.SOFT_KEY_1, "戻る");
					setSoftLabel(Frame.SOFT_KEY_2, "次へ");
					kakuninM(
						"行動・情報感度",
						"32.お客さまへ一歩近付こう。",
						"お客さまの前に顔を出そう。",
						"33.キビキビ、テキパキ、",
						"迅速に行動しよう。",
						"34.基本動作を徹底し、",
						"ミスがない正確なサービスをしよう。",
						"35.豊富な業務知識で、",
						"プロとして自信ある応対をしよう。",
						"",
						"",
						g);
					break;
				case KODO_JOUHOU2 :
					setSoftLabel(Frame.SOFT_KEY_1, "戻る");
					setSoftLabel(Frame.SOFT_KEY_2, "MENU");
					kakuninM(
						"行動・情報感度",
						"36.お客さまから言われてから",
						"やるのではなく、こちらから",
						"すすんで一声かけ、先んじて行動しよう。",
						"37.お客さまの声に素直な気持ちで",
						"耳を傾け、速やかに報告し、",
						"全員で共有しよう。",
						"39.「自分がお客さまだったら",
						"どうしてもらいたいか」",
						"といつも考えて行動しよう。",
						"",
						g);
					break;
				case MIDASINAMI :
					setSoftLabel(Frame.SOFT_KEY_1, "戻る");
					setSoftLabel(Frame.SOFT_KEY_2, "次へ");
					kakuninM(
						"接遇・身だしなみ・姿勢・表情",
						"7.全ての人に好感を与える",
						"清潔な身だしなみに整えよう。",
						"8.背筋をピンと伸ばして、",
						"良い姿勢をキープしよう。",
						"9.応対は、体をむけて、",
						"目線をむけて。",
						"10.手や腕を後ろに回したり、",
						"腕組みしたりせずに、手は",
						"体側に添わせるか前で組もう。",
						"",
						g);
					break;
				case MIDASINAMI2 :
					setSoftLabel(Frame.SOFT_KEY_1, "戻る");
					setSoftLabel(Frame.SOFT_KEY_2, "MENU");
					kakuninM(
						"接遇・身だしなみ・姿勢・表情",
						"11.お客さまエリアでは私語厳禁。",
						"12.明るい表情、優しい顔つき、",
						"さわやかな笑顔を。",
						"13.最初と最後は、",
						"必ずアイコンタクトをとろう",
						"",
						"",
						"",
						"",
						"",
						g);
					break;
			}
		}
		/******************確認画面処理終了********************************************************/
		/******************診断4Ｓ********************************************************/
		if (41 <= state && state <= 47) {
			switch (state) {
				case SINDAN_FOURS :
					tokuten = 0;
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "次へ");
					sindanM(
						"いつも身の回りの「整理・",
						"整頓・(　　)・清潔（4S）」",
						"をしよう。",
						"1.掃除",
						"2.清掃",
						"3.整備",
						20,
						g);
					break;
				case SINDAN_FOURS2 :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "次へ");
					sindanM(
						"４Sの鉄則は「すぐ」やること。",
						"(　　)を積み重ねないこと。",
						"",
						"1.資料や雑誌",
						"2.資料や用具",
						"3.資料や汚れ",
						25,
						g);
					break;
				case SINDAN_FOURS3 :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "次へ");
					sindanM(
						"誰が見てもわかるように、",
						"すぐ取り出せるように",
						"(　　)しよう。",
						"1.整理整頓",
						"2.綺麗に",
						"3.美しく",
						8,
						g);
					break;
				case SINDAN_FOURS4 :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "次へ");
					sindanM(
						"社内のゴミは、",
						"(　　)ですすんで拾おう。",
						"",
						"1.メンバー全員",
						"2.社員全員",
						"3.みんな",
						15,
						g);
					break;
				case SINDAN_FOURS5 :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "次へ");
					sindanM(
						"大切なお客さまを(　　)",
						"お迎えする気持ちで、",
						"毎日清掃しよう。",
						"1.我が社に",
						"2.自らの家に",
						"3.我が家に",
						8,
						g);
					break;
				case SINDAN_FOURS6 :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "次へ");
					sindanM(
						"(　　)汚れもない、",
						"誰もが汚せない",
						"緊張感ある空気を作ろう。",
						"1.チリも",
						"2.どんな小さなゴミも",
						"3.粗大ゴミも",
						24,
						g);
					break;
				case SINDAN_FOURS_KEKKA :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "次へ");
					kekka(g);
					break;
			}
		}
		/******************診断4Ｓ終了********************************************************/
		/******************診断身だしなみ********************************************************/
		if (48 <= state && state <= 55) {
			switch (state) {
				case SINDAN_MIDASINAMI :
					tokuten = 0;
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "次へ");
					sindanM(
						"全ての人に好感を与える",
						"(　　)身だしなみに整えよう。",
						"",
						"1.カジュアルな",
						"2.清潔な",
						"3.きちんとした",
						7,
						g);
					break;
				case SINDAN_MIDASINAMI2 :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "次へ");
					sindanM(
						"背筋をピンと伸ばして、",
						"(　　)をキープしよう。",
						"",
						"1.良い姿勢",
						"2.正しい姿勢",
						"3.きりっとした姿勢",
						8,
						g);
					break;
				case SINDAN_MIDASINAMI3 :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "次へ");
					sindanM(
						"応対は、(　　)、",
						"目線をむけて。",
						"",
						"1.整然として",
						"2.姿勢を正しく",
						"3.体をむけて",
						30,
						g);
					break;
				case SINDAN_MIDASINAMI4 :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "次へ");
					sindanM(
						"(　　)を後ろに回したり、",
						"腕組みしたりせずに、手は",
						"体側に添わせるか前で組もう。",
						"1.手や腕",
						"2.手や足",
						"3.手",
						15,
						g);
					break;
				case SINDAN_MIDASINAMI5 :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "次へ");
					sindanM(
						"(　　)では私語厳禁。",
						"",
						"",
						"1.お客さまエリア",
						"2.応接室",
						"3.待合場所",
						25,
						g);
					break;
				case SINDAN_MIDASINAMI6 :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "次へ");
					sindanM(
						"明るい表情、優しい顔つき、",
						"(　　)な笑顔を。",
						"",
						"1.清潔",
						"2.快活",
						"3.さわやか",
						7,
						g);
					break;
				case SINDAN_MIDASINAMI7 :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "次へ");
					sindanM(
						"最初と最後は、",
						"必ず(　　)をとろう",
						"",
						"1.写真",
						"2.アイコンタクト",
						"3.意思疎通",
						8,
						g);
					break;
				case SINDAN_MIDASINAMI_KEKKA :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "次へ");
					kekka(g);
					break;
			}
		}
		/******************診断身だしなみ終了********************************************************/
		/******************診断あいさつ********************************************************/
		if (56 <= state && state <= 60) {
			switch (state) {
				case SINDAN_SETUGU_AISATU :
					tokuten = 0;
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "次へ");
					sindanM(
						"あいさつは、明るく(　　)、",
						"イキイキと。",
						"",
						"1.元気に",
						"2.大胆に",
						"3.大きな声で",
						28,
						g);
					break;
				case SINDAN_SETUGU_AISATU2 :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "次へ");
					sindanM(
						"お客様はもちろん、(　　)、",
						"関係者へのあいさつを",
						"積極的にしよう。",
						"1.社内で",
						"2.社員同士",
						"3.社外でも",
						40,
						g);
					break;
				case SINDAN_SETUGU_AISATU3 :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "次へ");
					sindanM(
						"あいさつは、(　　)。",
						"自分から先にしよう。",
						"",
						"1.先手必勝",
						"2.後手必敗",
						"3.色即是空",
						18,
						g);
					break;
				case SINDAN_SETUGU_AISATU4 :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "次へ");
					sindanM(
						"相手の目を見て、笑顔と",
						"(　　)をそえてあいさつしよう。",
						"",
						"1.気持ち",
						"2.お土産",
						"3.お辞儀",
						14,
						g);
					break;
				case SINDAN_SETUGU_AISATU_KEKKA :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "次へ");
					kekka(g);
					break;
			}
		}
		/******************診断あいさつ終了********************************************************/
		/******************診断言葉づかい********************************************************/
		if (61 <= state && state <= 69) {
			switch (state) {
				case SINDAN_SETUGU_KOTOBA :
					tokuten = 0;
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "次へ");
					sindanM(
						"「客」0点、「お客さん」",
						"(　)点、「お客さま」100点。",
						"",
						"1.30",
						"2.50",
						"3.90",
						10,
						g);
					break;
				case SINDAN_SETUGU_KOTOBA2 :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "次へ");
					sindanM(
						"素直な気持ちで、",
						"まず「(　　)」と返事しよう。",
						"",
						"1.いいえ",
						"2.はい",
						"3.ありがとう",
						9,
						g);
					break;
				case SINDAN_SETUGU_KOTOBA3 :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "次へ");
					sindanM(
						"(　　)、柔らかい口調で、",
						"落ち着いて話そう。",
						"",
						"1.てきぱきと",
						"2.元気よく",
						"3.ハキハキと",
						18,
						g);
					break;
				case SINDAN_SETUGU_KOTOBA4 :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "次へ");
					sindanM(
						"単語で話さず、",
						"(　　)会話しよう。",
						"",
						"1.英単語で",
						"2.文節で",
						"3.文章で",
						14,
						g);
					break;
				case SINDAN_SETUGU_KOTOBA5 :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "次へ");
					sindanM(
						"「(　　)」をつけて美しい",
						"言葉で話そう。",
						"",
						"1.ですたい",
						"2.です・ます",
						"3.あいさつ",
						14,
						g);
					break;
				case SINDAN_SETUGU_KOTOBA6 :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "次へ");
					sindanM(
						"相手の話は最後まで",
						"しっかり聞き、相づち、",
						"(　　)をしっかりしよう。",
						"1.アイコンタクト",
						"2.うなずき",
						"3.復唱",
						17,
						g);
					break;
				case SINDAN_SETUGU_KOTOBA7 :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "次へ");
					sindanM(
						"お願いやお断りを",
						"する時は(　　)言葉を使おう。",
						"",
						"1.丁寧な",
						"2.クッション",
						"3.スポンジ",
						8,
						g);
					break;
				case SINDAN_SETUGU_KOTOBA8 :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "次へ");
					sindanM(
						"(　　)は使わずに、",
						"みんなが分かる言葉で",
						"ご案内を。",
						"1.専門用語",
						"2.外国語",
						"3.プロフェッショナル",
						10,
						g);
					break;
				case SINDAN_SETUGU_KOTOBA_KEKKA :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "次へ");
					kekka(g);
					break;
			}
		}
		/******************診断言葉づかい終了********************************************************/
		/******************診断電話応対********************************************************/
		if (70 <= state && state <= 77) {
			switch (state) {
				case SINDAN_SETUGU_DENWA :
					tokuten = 0;
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "次へ");
					sindanM(
						"電話は3コール以内でとろう。",
						"（3コール以上のときは",
						"(　　)」と言う",
						"1.待たせたな",
						"2.すいません",
						"3.お待たせいたしました",
						10,
						g);
					break;
				case SINDAN_SETUGU_DENWA2 :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "次へ");
					sindanM(
						"電話を受ける時、かける時は、",
						"かける時は、(　　)、",
						"氏名をまず伝えよう。",
						"1.会社名、部署",
						"2.会社名、所属",
						"3.誠意と",
						24,
						g);
					break;
				case SINDAN_SETUGU_DENWA3 :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "次へ");
					sindanM(
						"電話に出るときの声の",
						"トーンは、ドレミファソの",
						"「(　)」の音で。",
						"1.ラ",
						"2.ソ",
						"3.レ",
						6,
						g);
					break;
				case SINDAN_SETUGU_DENWA4 :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "次へ");
					sindanM(
						"迅速な応対と、「(　　)」",
						"「お待たせいたしました」の",
						"一声を忘れずに。",
						"1.しばらくお待ちください",
						"2.少々お待ちください",
						"3.ちょっとまって",
						22,
						g);
					break;
				case SINDAN_SETUGU_DENWA5 :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "次へ");
					sindanM(
						"お待たせする場合、(　)、保留",
						"をかけ、こちらの会話が相手に",
						"聞こえないよう配慮しよう。",
						"1.お待ちさせる時は",
						"2.取り次ぐ場合は",
						"3.楽しませる場合は",
						13,
						g);
					break;
				case SINDAN_SETUGU_DENWA6 :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "次へ");
					sindanM(
						"電話を切るときは、",
						"相手が切ってから(　　)",
						"受話器を置こう。",
						"1.静かに",
						"2.そっと",
						"3.豪快に",
						25,
						g);
					break;
				case SINDAN_SETUGU_DENWA_KEKKA :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "次へ");
					kekka(g);
					break;
			}
		}
		/******************診断電話応対終了********************************************************/
		/******************診断行動情報感度********************************************************/
		if (78 <= state && state <= 85) {
			switch (state) {
				case SINDAN_KODO_JOUHOU :
					tokuten = 0;
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "次へ");
					sindanM(
						"お客さまへ(　　)近付こう。",
						"お客さまの前に顔を出そう。",
						"",
						"1.心から",
						"2.そっと",
						"3.一歩",
						8,
						g);
					break;
				case SINDAN_KODO_JOUHOU2 :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "次へ");
					sindanM(
						"(　　　　)",
						"迅速に行動しよう。",
						"",
						"1.お待ちさせないよう",
						"2.キビキビ、テキパキ、",
						"3.何事も",
						19,
						g);
					break;
				case SINDAN_KODO_JOUHOU3 :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "次へ");
					sindanM(
						"基本動作を徹底し、",
						"ミスがない(　　)をしよう。",
						"",
						"1.仕事",
						"2.完璧な奉仕",
						"3.正確なサービス",
						6,
						g);
					break;
				case SINDAN_KODO_JOUHOU4 :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "次へ");
					sindanM(
						"豊富な業務知識で、",
						"(　　)として自信ある",
						"応対をしよう。",
						"1.プロ",
						"2.専門家",
						"3.達人",
						5,
						g);
					break;
				case SINDAN_KODO_JOUHOU5 :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "次へ");
					sindanM(
						"お客さまから言われてから",
						"やるのではなく、こちらから",
						"(　　)、先んじて行動しよう。",
						"1.意図をくんで",
						"2.話を聞き",
						"3.すすんで一声かけ",
						33,
						g);
					break;
				case SINDAN_KODO_JOUHOU6 :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "次へ");
					sindanM(
						"(　　)に素直な気持ちで",
						"耳を傾け、速やかに",
						"報告し、全員で共有しよう。",
						"1.お客さまの声",
						"2.世間の声",
						"3.世論",
						16,
						g);
					break;
				case SINDAN_KODO_JOUHOU7 :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "次へ");
					sindanM(
						"「自分が(　　)だったら",
						"どうしてもらいたいか」",
						"といつも考えて行動しよう。",
						"1.取引先",
						"2.相手",
						"3.お客さま",
						13,
						g);
					break;
				case SINDAN_KODO_JOUHOU_KEKKA :
					setSoftLabel(Frame.SOFT_KEY_1, "");
					setSoftLabel(Frame.SOFT_KEY_2, "次へ");
					kekka(g);
					break;
			}
		}
		/******************診断行動情報感度終了********************************************************/
		g.unlock(true);
	}
	private void menu(Graphics g) {
		g.setColor(Graphics.getColorOfRGB(bcolorR, bcolorG, bcolorB));
		g.fillRect(0, 0, Display.getWidth(), Display.getHeight());
		String title = "MENU";
		String[] menu = { "5S度診断", "5Sを確認", "診断結果の記録を見る", "5Sの説明", "OPTION" };
		g.setColor(Graphics.getColorOfRGB(colorR, colorG, colorB));
		//MENU用画像の表示
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

		//タイトル表示
		int x = (getWidth() - f.stringWidth(title)) / 2;
		int y = 30;
		g.drawString(title, x, y);
		g.drawLine(x - 2, y + 2, x + f.stringWidth(title) + 2, y + 2);

		x = 60;
		int[] yi = { 60, 100, 140, 180, 220 };

		//フォーカス
		g.setColor(Graphics.getColorOfRGB(colorR, colorG, colorB));
		g.fillRect(
			x - margin / 2,
			yi[focusedMenu] - f.getHeight() - margin / 2,
			f.stringWidth(menu[focusedMenu]) + margin,
			f.getHeight() + margin);

		//メニュー項目表示
		for (int i = 0; i < menu.length; i++) {
			g.drawString(menu[i], x, yi[i]);
		}
		//フォーカスのあたっている項目は白文字にする
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
								new Dialog(Dialog.DIALOG_YESNO, "最高得点削除");
							dialog.setText("本当に削除しますか？");
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
									//チェック1にチェックが入っていたらそれをはずす、そうでないときは、
									//チェック２にチェックが入ってるときチェック１にチェックされたら、
									//チェック２のチェックをはずし、チェック１にチェックを入れ、
									//チェック３にチェックが入っているときチェック１にチェックされたら、
									//チェック３のチェックをはずし、チェック１にチェックを入れる。

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