import { Component, OnDestroy, OnInit } from '@angular/core';
import { FacetService } from '../services/facet.service';
import { Subscription } from 'rxjs';
import { Facet } from 'src/app/dto/facet';

@Component({
    selector: 'app-facets-view',
    templateUrl: './facets-view.component.html',
    styleUrls: ['./facets-view.component.scss']
})
export class FacetsViewComponent implements OnInit, OnDestroy {

    private facetsSubscription = Subscription.EMPTY;

    facets: Facet[] = [];

    public constructor(private facetService: FacetService) { }

    ngOnInit(): void {
        this.facetsSubscription = this.facetService.getFacets().subscribe(facets => {
            this.facets = facets;
        });
    }

    ngOnDestroy(): void {
        if (!!this.facetsSubscription) {
            this.facetsSubscription.unsubscribe();
        }
    }
}
