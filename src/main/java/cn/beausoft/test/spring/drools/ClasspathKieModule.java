package cn.beausoft.test.spring.drools;

import org.drools.compiler.kie.builder.impl.AbstractKieModule;
import org.kie.api.builder.ReleaseId;
import org.kie.api.builder.model.KieModuleModel;

import java.io.File;
import java.util.Collection;

public class ClasspathKieModule extends AbstractKieModule {

    public ClasspathKieModule(ReleaseId releaseId, KieModuleModel kModuleModel) {
        super(releaseId, kModuleModel);
    }

    @Override
    public byte[] getBytes() {
        return new byte[0];
    }

    @Override
    public boolean isAvailable(String pResourceName) {
        return false;
    }

    @Override
    public byte[] getBytes(String pResourceName) {
        return new byte[0];
    }

    @Override
    public Collection<String> getFileNames() {
        return null;
    }

    @Override
    public File getFile() {
        return null;
    }

    @Override
    public long getCreationTimestamp() {
        return 0;
    }
}
