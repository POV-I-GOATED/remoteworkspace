// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelgo<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "go"),
			"main");
	private final ModelPart body;

	public Modelgo(ModelPart root) {
		this.body = root.getChild("body");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, 21.5F, 0.0F, 0.0F, 1.5708F, 2.3562F));

		PartDefinition body_r1 = body.addOrReplaceChild("body_r1",
				CubeListBuilder.create().texOffs(-5, 0)
						.addBox(-4.0F, -0.5F, -4.5F, 16.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-3.0F, -3.0F, -4.5F, 0.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-4.0F, -3.0F, -2.0F, 16.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 2.5F, 0.0F, 0.0F, 0.7854F, 1.5708F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}