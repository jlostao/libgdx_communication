package com.mygdx.pr33;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

public class PR33_LostaoJ extends ApplicationAdapter {
	Dialog endDialog;
	Skin skin;
	Stage stage;

	public void create() {
		skin = new Skin(Gdx.files.internal("uiskin.json"));

		stage = new Stage();

		Gdx.input.setInputProcessor(stage);

		endDialog = new Dialog("Dialog", skin) {
			protected void result(Object object) {
				System.out.println("Select: " + object);
				Timer.schedule(new Task() {
					public void run() {
						endDialog.show(stage);
					}
				}, 1);
			}
		};
		// Set the size of the dialog
		endDialog.setSize(600, 300); // Adjust the width and height as per your requirement

		// Add buttons to the dialog
		TextButton button1 = new TextButton("Button 1", skin);
		endDialog.button(button1, 1L);

		TextButton button2 = new TextButton("Button 2", skin);
		endDialog.button(button2, 2L);

		// Add dialog to the stage
		stage.addActor(endDialog);

		// Center the dialog on the screen
		endDialog.setPosition((stage.getWidth() - endDialog.getWidth()) / 2, (stage.getHeight() - endDialog.getHeight()) / 2);

		// Show the dialog
		endDialog.show(stage);
	}

	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		stage.act();
		stage.draw();
	}

	public void dispose() {
		stage.dispose();
	}
}