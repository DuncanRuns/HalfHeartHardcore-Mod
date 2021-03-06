package me.duncanruns.hhh.mixin;

import net.minecraft.client.gui.screen.world.CreateWorldScreen;
import net.minecraft.world.Difficulty;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CreateWorldScreen.class)
public abstract class CreateWorldScreenMixin {

    @Shadow
    public boolean hardcore;

    @Shadow
    private Difficulty currentDifficulty;

    @Inject(method = "createLevel", at = @At("HEAD"))
    private void forceHardcoreMixin(CallbackInfo info) {
        currentDifficulty = Difficulty.HARD;
        hardcore = true;
    }
}