package net.labymod.addons.bettercrophitbox;

import net.labymod.api.LabyModAddon;
import net.labymod.settings.elements.ControlElement;
import net.labymod.settings.elements.SettingsElement;
import net.labymod.settings.elements.BooleanElement;
import net.labymod.utils.Consumer;
import net.labymod.utils.Material;
import net.minecraft.block.Block;

import java.util.List;

/**
 * Test addon
 */
public class BetterCropHitboxAddon extends LabyModAddon {

    private boolean enabledSetting;

    /**
     * Called when the addon gets enabled
     */
    @Override
    public void onEnable() {
        CropFunctions.createInstance(false);
    }

    /**
     * Called when the addon gets disabled
     */
    @Override
    public void onDisable() {
        CropFunctions.getInstance().update(false);
    }

    /**
     * Called when this addon's config was loaded and is ready to use
     */
    @Override
    public void loadConfig() {
        enabledSetting = getConfig().has( "Enabled" ) ? getConfig().get( "Enabled" ).getAsBoolean() : true;
        CropFunctions.getInstance().update(enabledSetting);
    }

    /**
     * Called when the addon's ingame settings should be filled
     *
     * @param subSettings a list containing the addon's settings' elements
     */
    @Override
    protected void fillSettings( List<SettingsElement> subSettings ) {
        subSettings.add( new BooleanElement( "Enabled" /* Display name */, new ControlElement.IconData( Material.LEVER ), new Consumer<Boolean>() {
            @Override
            public void accept( Boolean accepted ) {
                CropFunctions.getInstance().update(accepted);
            }
        } /* Change listener */, enabledSetting /* current value */ ) );
    }

}