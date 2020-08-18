package minesweeper.UI.startScreen;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DifficultyButtons {
    public static void addListenersToButtons(Button[] buttons) {
        for (Button button : buttons) {
            button.getButton().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent arg0) {
                    switch (button.getId()) {
                        case 0 -> Difficulties.veryEasyEvent();
                        case 1 -> Difficulties.easyEvent();
                        case 2 -> Difficulties.mediumEvent();
                        case 3 -> Difficulties.hardEvent();
                        case 4 -> Difficulties.veryHardEvent();
                        case 5 -> Difficulties.extremeEvent();
                    }
                }
            });
        }
    }
}
