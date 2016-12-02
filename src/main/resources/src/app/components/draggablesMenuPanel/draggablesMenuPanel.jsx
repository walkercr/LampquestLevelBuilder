import React, { Component, PropTypes } from 'react';
import { newDragTypes } from '../../constants/constants';
import DraggableMenuItem from '../draggableMenuItem/draggableMenuItem';

export default class DraggablesMenuPanel extends Component {
    static propTypes = {
        menuItems: PropTypes.arrayOf(React.PropTypes.object).isRequired,
        menuItemType: PropTypes.oneOf(Object.values(newDragTypes)).isRequired,
        title: PropTypes.string
    };
    
    static defaultProps = {
        title: ''
    };
    
    render() {
        const { menuItems, menuItemType, title } = this.props;
        
        return (
            <div className="draggables-menu-panel">
                <div className="draggables-menu-panel__header">
                    <p className="draggables-menu-panel__title">{title}</p>
                </div>
                <div className="draggables-menu-panel__body">
                    {menuItems.map((data, i) => 
                        <DraggableMenuItem key={i} data={data} dragType={menuItemType} />
                    )}
                </div>
            </div>
        );
    }
}