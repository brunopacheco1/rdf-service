import { Component, Input } from '@angular/core';
import { Facet } from 'src/app/domain/facet';

@Component({
    selector: 'app-facet-view',
    templateUrl: './facet-view.component.html',
    styleUrls: ['./facet-view.component.scss']
})
export class FacetViewComponent {

    @Input()
    facet: Facet | undefined;
}
