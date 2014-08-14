package org.drools.workbench.screens.testscenario.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.HasSelectionHandlers;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;

public class FactFieldSelector
        extends Composite
        implements HasSelectionHandlers<String> {

    @UiField
    ListBox fieldsListBox;

    interface FactFieldSelectorUiBinder
            extends
            UiBinder<Widget, FactFieldSelector> {

    }

    private static FactFieldSelectorUiBinder uiBinder = GWT.create( FactFieldSelectorUiBinder.class );

    public FactFieldSelector() {
        initWidget( uiBinder.createAndBindUi( this ) );
    }

    public void addField( String field ) {
        fieldsListBox.addItem( field );
    }

    public String getSelectedText() {
        return fieldsListBox.getItemText( fieldsListBox.getSelectedIndex() );
    }

    @Override
    public HandlerRegistration addSelectionHandler( final SelectionHandler<String> selectionHandler ) {
        return addHandler( selectionHandler, SelectionEvent.getType() );
    }
}