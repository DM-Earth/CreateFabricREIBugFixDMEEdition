package ho.artisan.createreibugfix;

import it.unimi.dsi.fastutil.objects.Object2BooleanMap;
import it.unimi.dsi.fastutil.objects.Object2BooleanOpenHashMap;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

public class CFREIBFMixinPlugin implements IMixinConfigPlugin {
    private final Object2BooleanMap<String> conditionalMixins = new Object2BooleanOpenHashMap<>();

    public CFREIBFMixinPlugin() {
        boolean isREIInstalled = CreateFabricREIBugFixMod.isREIInstalled();
        this.conditionalMixins.put("ho.artisan.createreibugfix.mixin.AssemblySpoutingMixin", isREIInstalled);
        this.conditionalMixins.put("ho.artisan.createreibugfix.mixin.BasinCategoryMixin", isREIInstalled);
        this.conditionalMixins.put("ho.artisan.createreibugfix.mixin.CreateDisplayMixin", isREIInstalled);
        this.conditionalMixins.put("ho.artisan.createreibugfix.mixin.CrushingCategoryMixin", isREIInstalled);
        this.conditionalMixins.put("ho.artisan.createreibugfix.mixin.MillingCategoryMixin", isREIInstalled);
        this.conditionalMixins.put("ho.artisan.createreibugfix.mixin.SequencedAssemblyRecipeMixin", isREIInstalled);
    }

    @Override
    public void onLoad(String mixinPackage) {

    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        return this.conditionalMixins.getOrDefault(mixinClassName, true);
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {

    }

    @Override
    public List<String> getMixins() {
        return null;
    }

    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {

    }

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {

    }
}
