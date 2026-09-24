package com.theislesoftheblestv2.theislesoftheblest;

import net.fabricmc.api.ModInitializer;

public class Theislesoftheblest implements ModInitializer {

    @Override
    public void onInitialize() {
        Storyline.init();
        Mod_Creative_Mod_Tabs.init();
    }
}
