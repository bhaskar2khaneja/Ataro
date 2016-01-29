package mule.presenters;

import mule.views.View;

public abstract class Presenter<V extends View, M> extends InputListener {
  protected V view;

  protected M model;

  public Presenter(V view, M model) {
    this.view = view;
    this.model = model;

    view.addListener(this);
  }
}
