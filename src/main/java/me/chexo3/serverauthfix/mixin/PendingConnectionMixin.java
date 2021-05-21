package me.chexo3.serverauthfix.mixin;


import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(targets = "net.minecraft.server.network.PendingConnection$1")
final class PendingConnectionMixin {

	@ModifyConstant(
		method = "run()V",
		constant = @Constant(stringValue = "http://www.minecraft.net/game/checkserver.jsp?user="),
		remap = false
	)
	private String correctSessionURL(String url) { return "http://session.minecraft.net/game/checkserver.jsp?user="; }
}
