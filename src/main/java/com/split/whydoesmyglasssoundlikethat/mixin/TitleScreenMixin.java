package com.split.whydoesmyglasssoundlikethat.mixin;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.toast.SystemToast;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.client.gui.screen.TitleScreen;
import org.json.*;
@Mixin(TitleScreen.class)
public class TitleScreenMixin {
    @Unique
    private boolean firstRenderCompleted = false;
    @Inject(method = "render", at = @At("HEAD"))
    private void onFirstRender(MatrixStack matrixStack, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        if (firstRenderCompleted) return;
        firstRenderCompleted = true;
        //get json from url and check if version is latest
        String url = "https://api.persn.dev/api/warden/getModFiles/wdmgslt/update.json";
        String json = "";
        try {
            json = new java.util.Scanner(new java.net.URL(url).openStream(), "UTF-8").useDelimiter("\\A").next();
        } catch (Exception e) {
            System.out.println("Failed to get version.json from github");
            return;
        }
        JSONObject obj = new JSONObject(json);
        String latestVersion = obj.getString("latestVersion");
        String currentVersion = FabricLoader.getInstance().getModContainer("whydoesmyglasssoundlikethat").get().getMetadata().getVersion().getFriendlyString();
        if (currentVersion.equals(latestVersion)) return;
        SystemToast toast = SystemToast.create(MinecraftClient.getInstance(), SystemToast.Type.TUTORIAL_HINT, Text.of(obj.getString("updateTitle")), Text.of(obj.getString("updateMessage")));
        MinecraftClient.getInstance().getToastManager().add(toast);
    }
}