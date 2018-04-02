import { CoursesService } from './courses.service';
import { Component } from '@angular/core';

@Component({
    selector: 'app-courses',
    providers: [CoursesService],
    template: `
        <h2>{{ getTitle() }}</h2>
        <ul>
            <li *ngFor="let course of courses">
                {{ course }}
            </li>
        </ul>
    `
})
export class CoursesComponent {
    private title = 'List of courses';
    courses;

    constructor(service: CoursesService) {
        this.courses = service.getCourses();
    }

    getTitle() {
        return this.title;
    }
}
