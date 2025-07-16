package bluesteel42.swampwood;

import bluesteel42.swampwood.standard_wood_initializer.StandardWoodInitializer;
import net.fabricmc.api.ClientModInitializer;

public class SwampWoodClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        StandardWoodInitializer.initializeWoodTypeClient();
    }
}
