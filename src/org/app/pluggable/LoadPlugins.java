package org.app.pluggable;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;

import org.java.plugin.ObjectFactory;
import org.java.plugin.PluginManager;
import org.java.plugin.PluginManager.PluginLocation;
import org.java.plugin.registry.Extension;
import org.java.plugin.registry.ExtensionPoint;
import org.java.plugin.registry.PluginDescriptor;
import org.java.plugin.standard.StandardPluginLocation;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;


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
	
    public ArrayList<Object[]> addDynamicPlugin() {
		
		try {
			
			PluginDescriptor core = pluginManager.getRegistry().getPluginDescriptor("org.app.plugin.core");
			
			ExtensionPoint point = pluginManager.getRegistry().getExtensionPoint(core.getId(), "Tool");
			
			ArrayList<Object[]> list = new ArrayList<Object[]>();
			
			for (Iterator<?> it = point.getConnectedExtensions().iterator(); it.hasNext();) {
			
				Extension ext = (Extension) it.next();
				
				PluginDescriptor descr = ext.getDeclaringPluginDescriptor();
				
				pluginManager.activatePlugin(descr.getId());
				
				ClassLoader classLoader = pluginManager.getPluginClassLoader(descr);
				Class<?> pluginCls = classLoader.loadClass(ext.getParameter("class").valueAsString());
				
			
				//System.out.println(" "+ext.getParameter("name").valueAsString());
				//System.out.println(" "+ext.getParameter("class").valueAsString());
				
				Hashtable params = new Hashtable();
				params.put("name", ext.getParameter("name").valueAsString());
				
				Object[] o = new Object[2];
				
				o[0] = pluginCls.newInstance();
				o[1] = params;
				
				list.add(o);				
				
			}
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
