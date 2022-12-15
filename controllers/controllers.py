# -*- coding: utf-8 -*-
from odoo import http

# class OfcOdoo(http.Controller):
#     @http.route('/ofc_odoo/ofc_odoo/', auth='public')
#     def index(self, **kw):
#         return "Hello, world"

#     @http.route('/ofc_odoo/ofc_odoo/objects/', auth='public')
#     def list(self, **kw):
#         return http.request.render('ofc_odoo.listing', {
#             'root': '/ofc_odoo/ofc_odoo',
#             'objects': http.request.env['ofc_odoo.ofc_odoo'].search([]),
#         })

#     @http.route('/ofc_odoo/ofc_odoo/objects/<model("ofc_odoo.ofc_odoo"):obj>/', auth='public')
#     def object(self, obj, **kw):
#         return http.request.render('ofc_odoo.object', {
#             'object': obj
#         })