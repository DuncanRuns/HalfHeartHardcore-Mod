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
    private Difficulty field_24289;

    @Shadow
    private Difficulty field_24290;

    @Inject(method = "createLevel", at = @At("HEAD"))
    private void forceHardcoreMixin(CallbackInfo info) {
        field_24289 = Difficulty.HARD;
        field_24290 = Difficulty.HARD;
        hardcore = true;
    }
}