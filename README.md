# Nalu
Nalu is a tiny framework that helps you to create GWT based applications quite easily. Nalu is using the HTML 5 history for routing and navigation. This means Nalu supports the browser's back-, forward-, and reload-button by default and without any need to implement something.


Nalu offers the following features:

* Fully support of the browser's back- forward- and relaod-button.

* An optional loader that will be executed at application start to load data from the server.

* A client side context, router and event bus which will be automatically injected in every controller. (Handler have only access to the context and the event bus)

* Filters to intercept routing.

* Full history support.

* Seperation of views into a controller and a component with framwork sided instantiation.

* a controller life-cycle using ```start```-, ```mayStop```- and ```stop```- similar to GWT Activities.

* Supports HTML links and programmatically routing thanks to a router.

* Controller based handler manager, that will remove all handlers from the event bus in case the controller is stopped to prevent memeory leaks (handler registratoins must be added to the manager).

* Support for UiBinder (nalu-plugin-gwt)

## Basic Concept
Nalu uses the hash of an url to navigate.

Example hash:
```
#[route]/[parameter_1]/[parameter_2]/[parameter_3]
```

where
* route: is the navigation end point
* parameter_x: are the paremeters of the route (it is possible to have a route without parameter or to use a route, that excepts paremter without parameter in inside the url.)

The following flow shows the steps to be done, once a routing is initiated. The flow will end with appending the new component to the DOM.

![Route Flow](https://github.com/mvp4g/nalu-parent/blob/master/etc/images/routeFlow.png)

To connect a component to a route, just create a controller class which extends ```AbstractComponentController```and add the controller annotation ```@Controller```.

```JAVA
@Controller(route = "/route/:parameter_1/:parameter_2/:parameter_3",
            selector = "content",
            component = MyComponent.class,
            componentInterface = IMyComponent.class)
public class MyController
    extends AbstractComponentController<MyApplicationContext, IMyComponent, HTMLElement>
    implements ISearchComponent.Controller {
}
```

To navigate to a new route use:
```JAVA
    this.router.route("/route",
                      parameter_1,
                      parameter_2);
```
inside the controller.
The Router is automaticly injected in the controller. To route to a new component call the route method and add at least the new route. If the route has parameters, just add them as additional parameters. (**Important:** Parameters must be Strings!)

## Using
To use Nalu, clone the repo and run ```maven clean install``` (ToDo: move to maven central) and add the following dependencies to your pom:

```XML
<dependency>
    <groupId>comgithub..mvp4g</groupId>
    <artifactId>nalu</artifactId>
    <version>LATEST</version>
</dependency>
<dependency>
    <groupId>comgithub..mvp4g</groupId>
    <artifactId>nalu-processor</artifactId>
    <version>LATEST</version>
</dependency>
```

Depening on the widget set the project is using, add one of the following plugins:

If the project uses a widget set based on Elemetal2, Elememento or Domino-UI, use the **Nalu-Plugin-Elemental2** by adding the following lines to your pom:

```XML
<dependency>
    <groupId>com.github..mvp4g</groupId>
    <artifactId>nalu-plugin-elemental2</artifactId>
    <version>LATEST</version>
</dependency>
```

If the project uses a widget set based on GWT 2.8.2 or newer, use the **Nalu-Plugin-GWT** by adding the following lines to your pom:

```XML
    <dependency>
      <groupId>com.github.nalukit</groupId>
      <artifactId>nalu-plugin-gwt</artifactId>
      <version>LATEST</version>
    </dependency>
    <dependency>
      <groupId>com.github.nalukit</groupId>
      <artifactId>nalu-plugin-gwt-processor</artifactId>
      <version>LATEST</version>
    </dependency>
```


See the wiki for more informations on Nalu and how to use it.

## Wiki
More useful information about Nalu and how to use it, can be find inside the [Wiki](https://github.com/mvp4g/nalu/wiki).

## J2CL / GWT3
With the next version of GWT (GWT 3) and the new J2CL transpiller, there will be major changes in the GWT developmemt. For example: JSNI and generators, besides other things, will be gone. To be prepared for the futere things like JSNI, generators or any other dependency to GTW has to be avoided. Nalu uses only the already migrated ```gwt-events``` from ```org.gwtproject```.

Nalu has **no** dependency to gwt-user nor Nalu's dependencies! Nalu does not use JSNI, generators or anything else from GWT. Nalu is ready to use with J2CL / GWT 3.

## To get in touch with the developer
Please use the [MVP4G Gitter room](https://gitter.im/mvp4g/mvp4g).

## Examples
There are some examples that show how to set up and how to use Nalu: [https://github.com/mvp4g/nalu-examples](https://github.com/mvp4g/nalu-examples).

## Project Generator
To speed up creating a Nalu project, the [Nalu Boot Starter Project Generator](http://www.mvp4g.org/gwt-boot-starter-nalu/GwtBootStarterNalu.html) (which is also based on Nalu) can be used. The project generator will generate a Maven project, which can be imported to your preferred IDE and is ready to use. Run **mvn: devmode:** to start the generated project.

Here are some notes about the project generator: [Nalu Project Generator](https://github.com/mvp4g/gwt-boot-starter-nalu).


## Notes
Nalu is still in progress. Validation and documentation are not finished yet.In casse you find a bug, please open an issue or post it inside the [MVP4G Gitter room](https://gitter.im/mvp4g/mvp4g).

## Known issues

* documentation (in progress)

* tests need to be improved (in progress)
