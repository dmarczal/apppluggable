package org.app.pluggable;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Iterator;
import java.util.LinkedHashMap;

import org.app.ApplicationPlugin;
import org.java.plugin.ObjectFactory;
import org.java.plugin.PluginManager;
import org.java.plugin.PluginManager.PluginLocation;
import org.java.plugin.registry.Extension;
import org.java.plugin.registry.ExtensionPoint;
import org.java.plugin.registry.PluginDescriptor;
import org.java.plugin.standard.StandardPluginLocation;


public class LoadPlugins {

	private PluginManager pluginManager;
	public static final File pluginsDir = new File("plugins");
	
	public LoadPlugins(){
		load();
	}
	
	private void load() {
		pluginManager = ObjectFactory.newInstance().createManager();
		File pluginsDir = new File("plugins");

		System.out.println(System.getProperty("user.dir"));
		
		File[] plugins = pluginsDir.listFiles(new FilenameFilter() {

			public boolean accept(File dir, String name) {
				return name.toLowerCase().endsWith(".zip");
			}

		});

		try {
			
			
			PluginLocation[] locations = new PluginLocation[plugins.length];

			for (int i = 0; i < plugins.length; i++) {
				System.out.println(plugins[i]);
				locations[i] = StandardPluginLocation.create(plugins[i]);
				System.out.println(locations[i]);
			}

			pluginManager.publishPlugins(locations);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
	
    public LinkedHashMap<String, ApplicationPlugin> addDynamicPlugin() {
		
		try {
			
			PluginDescriptor core = pluginManager.getRegistry().getPluginDescriptor("org.app.plugin.core");
			
			ExtensionPoint point = pluginManager.getRegistry().getExtensionPoint(core.getId(), "Tool");
			
			LinkedHashMap<String, ApplicationPlugin> objects = new LinkedHashMap<String, ApplicationPlugin>();
			
			for (Iterator<?> it = point.getConnectedExtensions().iterator(); it.hasNext();) {
			
				Extension ext = (Extension) it.next();
				
				PluginDescriptor descr = ext.getDeclaringPluginDescriptor();
				
				pluginManager.activatePlugin(descr.getId());
				
				ClassLoader classLoader = pluginManager.getPluginClassLoader(descr);
				Class<?> pluginCls = classLoader.loadClass(ext.getParameter("class").valueAsString());
				
			
				//System.out.println(" "+ext.getParameter("name").valueAsString());
				//System.out.println(" "+ext.getParameter("class").valueAsString());
				
				
				
				objects.put(ext.getParameter("name").valueAsString(), (ApplicationPlugin) pluginCls.newInstance());				
				
			}
			
			return objects;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
