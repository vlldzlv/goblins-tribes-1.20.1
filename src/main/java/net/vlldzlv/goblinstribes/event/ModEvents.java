package net.vlldzlv.goblinstribes.event;

import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.vlldzlv.goblinstribes.GoblinsTribes;
import net.vlldzlv.goblinstribes.client.NyuflerRenderer;
import net.vlldzlv.goblinstribes.entity.ModEntities;
import net.vlldzlv.goblinstribes.entity.Nyufler;

public class ModEvents {
	@Mod.EventBusSubscriber(modid = GoblinsTribes.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class ModBusEvents {
		@SubscribeEvent
		public static void onRegisterAttributes(EntityAttributeCreationEvent event) {
			event.put(ModEntities.NYUFLER.get(), Nyufler.createAttributes().build());
		}
	}

	@Mod.EventBusSubscriber(modid = GoblinsTribes.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD,
			value = net.minecraftforge.api.distmarker.Dist.CLIENT)
	public static class ClientModBusEvents {
		@SubscribeEvent
		public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
			event.registerEntityRenderer(ModEntities.NYUFLER.get(), NyuflerRenderer::new);
		}
	}
}
