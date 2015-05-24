/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.defaultComponent;

import components.defaultComponent.Component;
import core.Input;

/**
 *
 * @author Honza
 */
public abstract class InputComponent extends Component
{

    protected Input input;

    public InputComponent(Input input)
    {
        super("input");
        this.input = input;
    }

}
